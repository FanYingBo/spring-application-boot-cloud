package com.study.selfs.aop.controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAopController {

    @GetMapping("/say")
    public String say(String name){
        if(!StringUtils.hasText(name)){
            throw new NullPointerException(" name 不能为空");
        }
        return "hello，"+name;
    }
}
