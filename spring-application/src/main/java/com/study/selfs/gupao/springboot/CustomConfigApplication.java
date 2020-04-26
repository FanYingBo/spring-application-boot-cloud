package com.study.selfs.gupao.springboot;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CustomConfigApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CustomConfigApplication.class).web(WebApplicationType.SERVLET).build(args).run();
    }
}
