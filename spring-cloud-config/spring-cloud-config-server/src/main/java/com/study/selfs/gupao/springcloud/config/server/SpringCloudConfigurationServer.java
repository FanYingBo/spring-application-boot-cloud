package com.study.selfs.gupao.springcloud.config.server;


import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigurationServer {

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudConfigurationServer.class,args);


    }


    /**
     * 自定义properties 覆盖系统原有的propertiesSource
     * @return
     */
//    @Bean
//    public EnvironmentRepository myEnvironmentRepository(){
//        return (application, profile, label) -> {
//
//            Map<String, Object> hashMap = new HashMap<>();
//
//            hashMap.put("name","小樊");
//            PropertySource mapPropertySource = new PropertySource("map",hashMap);
//
//            Environment environment = new Environment("default",profile);
//
//            List<PropertySource> propertySources = environment.getPropertySources();
//
//            propertySources.add(mapPropertySource);
//
//            return environment;
//        };
//    }
}

