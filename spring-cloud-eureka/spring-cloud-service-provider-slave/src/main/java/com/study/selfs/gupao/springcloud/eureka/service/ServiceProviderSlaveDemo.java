package com.study.selfs.gupao.springcloud.eureka.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderSlaveDemo {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderSlaveDemo.class,args);
    }

}
