package com.study.selfs.gupao.springcloud.zookeeper.client.config;

import com.study.selfs.gupao.springcloud.zookeeper.client.cache.TargetInstanceCache;
import com.study.selfs.gupao.springcloud.zookeeper.client.handle.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class BeanInitializeConfiguration{

    @Autowired
    private DiscoveryClient discoveryClient;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public LoadBalancedRetryFactory loadBalancedRetryFactory(){
        return new LoadBalancedRetryFactory() {
            @Override
            public BackOffPolicy createBackOffPolicy(String service) {
                return new ExponentialBackOffPolicy();
            }
        };
    }


    @Bean
    public RouterFunction<ServerResponse> save(UserHandler userHandler){
        return route(POST("/zk/dis/user/save"),userHandler::saveUser);
    }

    @Bean
    @Scheduled(fixedRate = 1000*3)
    public TargetInstanceCache targetInstance(@Value("${zookeeper.discovery.server.instance.name}") String tartServiceName){
        Set<String> targetUrls = discoveryClient.getInstances(tartServiceName)
                .stream()
                .map(serviceInstance -> serviceInstance.isSecure()
                        ? "https://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
                        : "http://"+serviceInstance.getHost() + ":" + serviceInstance.getPort())
                .collect(Collectors.toSet());
        return new TargetInstanceCache(targetUrls);
    }



}
