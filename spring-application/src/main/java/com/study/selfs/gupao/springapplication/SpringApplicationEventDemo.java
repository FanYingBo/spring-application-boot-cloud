package com.study.selfs.gupao.springapplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

//@EnableAutoConfiguration
public class SpringApplicationEventDemo {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(SpringApplicationEventDemo.class);
        springApplicationBuilder.listeners(event -> {
            System.err.println("事件："+event.getClass().getName());
        }).run().close();

    }
}
