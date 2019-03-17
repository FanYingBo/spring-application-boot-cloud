package com.study.selfs.gupao.springcloud.feign.discovery;


import com.study.selfs.gupao.springcloud.feign.service.IPersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = IPersonService.class)
public class FeignHttpClientDemo {
    public static void main(String[] args) {
        SpringApplication.run(FeignHttpClientDemo.class,args);
    }

}
