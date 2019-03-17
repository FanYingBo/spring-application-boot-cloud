package com.study.self.gupao.hystrix.controller;


import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Hystrix 实现熔断机制
 * properties 见地址 ：https://github.com/Netflix/Hystrix/wiki/Configuration
 */
@RestController
public class HystrixController {

    private static final Random random = new Random();
    // 注解方式实现
    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "fallBack" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")
            })
    public String sayHello() throws InterruptedException {
        int nextInt = random.nextInt(200);
        System.out.println("thread costs: "+nextInt+" ms");
        Thread.sleep(nextInt);
        return "hello world";
    }


    @GetMapping("/hello2")
    public String sayHello_() {
        return new HelloWorldCommand().execute();
    }

    public String fallBack(){
        return "Fatal";
    }

    // API方式实现
    private class HelloWorldCommand extends com.netflix.hystrix.HystrixCommand<String> {

        protected HelloWorldCommand() {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("OK"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionTimeoutInMilliseconds(100)));
        }

        @Override
        protected String run() throws Exception {
            int nextInt = random.nextInt(200);
            System.out.println("thread costs: "+nextInt+" ms");
            Thread.sleep(nextInt);
            return "hello world";
        }

        @Override
        protected String getFallbackMethodName() {
            return HystrixController.this.fallBack();
        }


    }
}
