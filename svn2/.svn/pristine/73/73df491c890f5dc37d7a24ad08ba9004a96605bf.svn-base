package com.qiangfeng.oasystem.controller;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public ModelAndView handler(Exception e){
        e.printStackTrace();
        if (e instanceof UnauthenticatedException){
            return new ModelAndView("/index");
        }else if (e instanceof UnauthorizedException){
            return new ModelAndView("/unza");
        }else {
            return new ModelAndView("/error");
        }
    }
}
