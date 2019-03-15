package com.study.selfs.gupao.springboot;

import com.study.selfs.gupao.custom.springboot.starter.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @Autowired
    private CustomConfig customConfig;

    @GetMapping("/custom")
    public String  getCustomConfig(){
        return "custom config value = " + customConfig.getConfig();
    }
}
