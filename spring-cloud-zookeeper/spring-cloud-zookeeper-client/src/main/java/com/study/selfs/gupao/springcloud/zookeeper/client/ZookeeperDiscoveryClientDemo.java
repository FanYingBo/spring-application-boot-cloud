package com.study.selfs.gupao.springcloud.zookeeper.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperDiscoveryClientDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZookeeperDiscoveryClientDemo.class)
                .web(WebApplicationType.REACTIVE)
                .build()
                .run(args);
    }
}
