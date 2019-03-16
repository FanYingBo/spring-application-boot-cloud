package com.study.selfs.gupao.springcloud.service.consumer.service;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.study.selfs.gupao.springcloud.user.domain.User;
import com.study.selfs.gupao.springcloud.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;


@Service
public class ProxyUserService  implements UserService {

    @Autowired
	@LoadBalanced//初始化和注入的时候都需要加@LoadBalanced
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${provider.instanceid}")
    private String instanceId;

    @Override
    public User save(User user) {
        return restTemplate.postForObject(instanceId+"/user/save", user, User.class);
    }

    @Override
    public Collection listUsers() {
        return restTemplate.getForObject(instanceId+"/user/list",Collection.class);
    }
}
