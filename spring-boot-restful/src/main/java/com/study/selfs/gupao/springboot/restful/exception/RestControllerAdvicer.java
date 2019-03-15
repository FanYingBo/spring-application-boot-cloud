package com.study.selfs.gupao.springboot.restful.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * RestControllerAdvice == ControllerAdvice + ResponseBody 页面响应  也可以捕获后处理异常
 */
//@ControllerAdvice
@RestControllerAdvice
public class RestControllerAdvicer {

    @ExceptionHandler(NullPointerException.class)
    //@ResponseBody
    public Object advice(Throwable throwable){
        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("exception",throwable.getMessage());
        return dataMap;
    }

}
