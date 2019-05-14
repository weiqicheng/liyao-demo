package com.liyao.common.aspect;

import com.liyao.common.util.LogAopUtil;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
@Aspect
/**
 * 可以使用 @Order 注解指定切面的优先级, 值越小优先级越高
 */
//@Order(2)
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
     * 使用 @Pointcut 来声明切入点表达式.
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
     * （..）表示任意参数
     *  execution(* com.liyao..*.*(..))
     整个表达式可以分为五个部分：

     1、execution(): 表达式主体。

     2、第一个*号：表示返回类型，*号表示所有的类型。

     3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。

     4、第二个*号：表示类名，*号表示所有的类。

     5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */
    @Pointcut("execution(* com.liyao..*.*(..))")
    public void declareJointPointExpression() {
    }


    //声明该方法执行之前执行，前置通知
    //直接导入切面点，上面的
/*    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        log.info("这是切面开始打印出来的--->The method " + methodName + " begins with " + Arrays.asList(args));
    }*/

    //后置通知：在目标方法执行后（无论是否发生异常），执行通知
    //在后置通知中还不能访问目标方法的执行的结果，不是在执行方法后调用的
    /**
     * 这是切面开始打印出来的--->The method add begins with [3, 5]
     * 这是切面结束打印出来的--->The method add ends
     * 和--->8
     */
/*    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("这是切面结束打印出来的--->The method " + methodName + " ends");
    }*/

    /**
     * 环绕切面，一般用的不是很多，类似于动态代理，可以包含前面4种的任意个
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
     * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
     * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
     */
   /* @Around("declareJointPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result = null;
        String methodName = pjd.getSignature().getName();
        try {
            //前置通知
            log.info("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            //返回通知
            log.info("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            //异常通知
            log.info("The method " + methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        //后置通知
        log.info("The method " + methodName + " ends");

        return result;
    }*/

    /**
     * 带有返回值的切面
     * 在方法法正常结束受执行的代码
     * 返回通知是可以访问到方法的返回值的!
     * 可以使用returning = "result"进行获取后得到
     */
/*    @AfterReturning(value = "declareJointPointExpression()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("The method " + methodName + " ends with " + result);
    }*/

    /**
     * 异常处理切面
     * 在目标方法出现异常时会执行的代码.
     * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
     */
    @AfterThrowing(value = "declareJointPointExpression()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        log.info("The method " + methodName + " occurs excetion:" + e);
    }



    /**
     * controller的前置通知方法，用于获取注解信息，存入数据库
     *
     * @param apiOperation 这个是类上注解是什么，我这里直接用了swagger2的注解来获取方法的描述
     * @return
     */
    @Before("declareJointPointExpression()&& @annotation(apiOperation)")
    public void beforeMethod(JoinPoint joinPoint, ApiOperation apiOperation) throws NotFoundException, ClassNotFoundException {
        if (apiOperation != null) {
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method targetMethod = methodSignature.getMethod();
            // 获取方法名称
            String methodName = targetMethod.getName();
            //获取所有参数值
            Object[] args = joinPoint.getArgs();
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String classType = joinPoint.getTarget().getClass().getName();
            Class<?> clazz = Class.forName(classType);
            String clazzName = clazz.getName();
            // 获取参数名称和值的json
            StringBuffer sb = LogAopUtil.getNameAndArgs(this.getClass(), clazzName, methodName, args);
            log.info("请求类方法参数名称和值：" + sb);
            // 打印请求内容
            log.info("===============请求内容===============");
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
            log.info("自定义的注释名称" + apiOperation.value());
            // 获取参数名称和值
            sb = LogAopUtil.getNameAndArgs(this.getClass(), clazzName, methodName, args);
            log.info("请求类方法参数名称和值：" + sb);
            log.info("===============请求内容===============");
        }
    }


}