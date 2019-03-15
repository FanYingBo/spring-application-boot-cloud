package com.study.selfs.gupao.springcloud.eureka.service.master.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderMasterDemo {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderMasterDemo.class,args);
    }

}
