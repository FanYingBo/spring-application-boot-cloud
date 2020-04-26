package com.study.selfs.gupao.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @GetMapping("/custom")
    public String  getValue(){
        return "custom config value = ";
    }
}
