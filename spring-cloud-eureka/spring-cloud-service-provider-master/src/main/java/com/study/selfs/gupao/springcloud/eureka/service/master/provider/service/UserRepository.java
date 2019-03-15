package com.study.selfs.gupao.springcloud.eureka.service.master.provider.service;


import com.study.selfs.gupao.springcloud.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class UserRepository {

    private ConcurrentMap<Long,User> userConcurrentMap = new ConcurrentHashMap<>();


    public User save(User user){
        System.out.println("provider slave add User："+user);
        return userConcurrentMap.put(user.getId(),user) == null ? user:null;
    }

    public Collection findAll(){
        return userConcurrentMap.values();
    }

}
