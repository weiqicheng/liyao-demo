package com.liyao.authentication.exception;

import com.liyao.authentication.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 实现的接口中的参数说明：
 * 第一个是指我们的要验证的注解是什么
 * 第二个是指验证的数据类型是什么
 */
public class MyConstarintValidator implements ConstraintValidator<MyConstraint,Object> {
    /**
     * 自己定义的方法类，在校验的时候我可以去查询数据库
     */
    @Autowired
    SysDictService sysDictService;
    /**
     * 初始化方法
     * @param constraintAnnotation
     */
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("init my validator");
    }

    /**
     * 自己的校验逻辑
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean b = sysDictService.selectById(1).getDictName().equalsIgnoreCase(value + "");
        System.out.println(value);
        //返回true成功，返回false失败
        return b;
    }
}
