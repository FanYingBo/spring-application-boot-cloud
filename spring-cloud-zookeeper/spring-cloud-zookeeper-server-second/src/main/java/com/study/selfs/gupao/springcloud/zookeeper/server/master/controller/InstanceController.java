package com.study.selfs.gupao.springcloud.zookeeper.server.master.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstanceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/zk/services")
    public List<String> getAllServices(){
        return discoveryClient.getServices();
    }
    @GetMapping("/zk/instances/{serviceName}")
    public List<ServiceInstance> getAllInstanceByServiceName(@PathVariable String serviceName){
        return discoveryClient.getInstances(serviceName);
    }
}
