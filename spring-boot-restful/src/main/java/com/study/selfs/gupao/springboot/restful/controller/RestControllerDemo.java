package com.study.selfs.gupao.springboot.restful.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RestControllerDemo {

    @GetMapping("/index")
    public String index(){
        return "hello world";
    }
    @GetMapping("/npt")
    public void noOpt(){
        throw new NullPointerException("示范异常捕获！");
    }
    @GetMapping("/data")
    public Object data(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name","jack");
        hashMap.put("age",21);
        hashMap.put("job","IT");
        return hashMap;
    }

}
