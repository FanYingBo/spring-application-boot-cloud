package com.study.selfs.gupao.springcloud.zookeeper.client.service;

import com.study.selfs.gupao.springcloud.user.domain.User;
import com.study.selfs.gupao.springcloud.user.domain.UserService;
import com.study.selfs.gupao.springcloud.zookeeper.client.cache.TargetInstanceCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TargetInstanceCache targetInstanceCache;

    @Override
    public User save(User user) {
        // snapshot
        List<String> urls = new ArrayList<>(targetInstanceCache.getUrls());
        String serviceUrl = urls.get(new Random().nextInt(urls.size()));
        return restTemplate.postForObject(serviceUrl+"/zk/server/user/save",user,User.class);
    }

    @Override
    public Collection listUsers() {
        return null;
    }
}
