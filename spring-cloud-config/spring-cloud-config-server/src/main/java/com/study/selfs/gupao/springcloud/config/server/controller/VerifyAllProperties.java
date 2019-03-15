package com.study.selfs.gupao.springcloud.config.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class VerifyAllProperties {

    @Autowired
    private MultipleJGitEnvironmentRepository defaultEnvironmentRepository;


    @GetMapping("/proper")
    public String getProperties(){
        StringBuilder sb = new StringBuilder();
        ConfigurableEnvironment environment = defaultEnvironmentRepository.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Iterator<PropertySource<?>> iterator = propertySources.iterator();
        for(;iterator.hasNext();){
            PropertySource<?> next = iterator.next();
            sb.append(next.getName()+" "+next.getSource()+"\n");
        }
        return sb.toString();
    }

}
