package com.study.selfs.gupao.springcloud.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulServiceProvider {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceProvider.class,args);
    }
}
