package com.study.selfs.gupao.springcloud.eureka.server.slave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServceSlaveDemo {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServceSlaveDemo.class,args);
    }

}
