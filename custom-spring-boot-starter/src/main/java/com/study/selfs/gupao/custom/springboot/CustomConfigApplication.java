package com.study.selfs.gupao.custom.springboot;

import com.study.selfs.gupao.custom.springboot.starter.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomConfigApplication {


    public static void main(String[] args) {
        SpringApplication.run(CustomConfigApplication.class,args);
    }
}
