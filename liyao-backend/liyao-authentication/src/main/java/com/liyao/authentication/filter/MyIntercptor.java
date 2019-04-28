package com.liyao.authentication.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyIntercptor implements HandlerInterceptor {
    /**
     * 控制器被调用之前所执行的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("preHandle");
        //获得调用类的名字
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        //获得调用的方法名字
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        //记录请求开始时间
        httpServletRequest.setAttribute("startTime",System.currentTimeMillis());

        return true;
    }

    /**
     * 控制器被调用之后所执行的方法，如果方法抛异常了这个方法就不会执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("postHandle 耗时："+(System.currentTimeMillis()-startTime));
    }

    /**
     * 无论是否抛异常控制器被调用之后都会执行此方法，类似于finally
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("afterCompletion 耗时："+(System.currentTimeMillis()-startTime));
        System.out.println("afterCompletion");
    }
}
