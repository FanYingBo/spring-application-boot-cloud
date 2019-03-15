package com.study.selfs.gupao.springcloud.eureka.service.slave.provider.controller;


import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * spring cloud两种方式对Eureka 的注册客户端进行管理
 * @see EurekaClientAutoConfiguration#discoveryClient(EurekaInstanceConfig, EurekaClient)
 * @see EurekaClientAutoConfiguration.EurekaClientConfiguration#eurekaClient(ApplicationInfoManager, EurekaClientConfig)
 *
 */
@RestController
public class InstnceController {

    @Autowired
    private DiscoveryClient discoveryClient;// EurekaClient
    @Autowired
    private EurekaClient eurekaClient;
    @GetMapping("/instance")
    public Collection getServiceInstance(){

        //第一种方式拿到所有的eureka注册信息
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = null;
        for(String serviceId : services){
            instances = discoveryClient.getInstances(serviceId);
        }
        return instances;

//        Applications applications = eurekaClient.getApplications();
//        List<Application> registeredApplications = applications.getRegisteredApplications();
//        return registeredApplications;
    }
}
