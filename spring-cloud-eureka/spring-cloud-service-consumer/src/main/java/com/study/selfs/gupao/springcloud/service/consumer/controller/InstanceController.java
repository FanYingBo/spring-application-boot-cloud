package com.study.selfs.gupao.springcloud.service.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class InstanceController {

//    @Autowired
//    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${provider.instanceid}")
    private String instanceId;

    @GetMapping("/instance")
    public Collection getServiceInstance(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = null;
        for(String serviceId : services){
            instances = discoveryClient.getInstances(serviceId);
        }
        return instances;
    }
}
