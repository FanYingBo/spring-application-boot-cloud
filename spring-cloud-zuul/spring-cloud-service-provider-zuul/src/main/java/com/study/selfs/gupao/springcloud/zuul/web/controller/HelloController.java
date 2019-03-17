package com.study.selfs.gupao.springcloud.zuul.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/say")
    public String say(){
        return  "hello , Server 1";
    }


    @GetMapping("/fatal")
    public String fatal(){
        return "it's fallback" ;
    }
}
