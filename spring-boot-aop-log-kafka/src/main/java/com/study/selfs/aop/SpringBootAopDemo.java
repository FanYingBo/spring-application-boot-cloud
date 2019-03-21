package com.study.selfs.aop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.kafka.annotation.EnableKafka;

/**
 *
 * 切面编程可以对日志进行收集整理单独对日志操作而不影响原先的方法
 * 通过kafka对日志进行收集
 */

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableKafka
public class SpringBootAopDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopDemo.class,args);
    }
}
