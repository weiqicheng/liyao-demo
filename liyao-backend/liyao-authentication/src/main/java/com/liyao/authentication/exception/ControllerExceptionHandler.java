package com.liyao.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
//这是一个用于处理异常的注解，表明这个类中的方法是用来处理控制器的异常的本身并不处理http请求。
@ControllerAdvice
public class ControllerExceptionHandler {

    //这个注解表示，方法处理的是什么异常，在任何一个控制器中抛出这个异常都会转到这个方法来处理
    @ExceptionHandler(UserNotExitException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//给前台返回的状态码是什么
    public Map<String, Object> userNotExitException(UserNotExitException ex) {
        Map<String, Object> result=new HashMap<>();
        result.put("id",ex.getId());
        result.put("massage",ex.getMessage());
        return result;
    }
}
