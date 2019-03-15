package com.study.selfs.gupao.springcloud.zookeeper.server.master.repository;

import com.study.selfs.gupao.springcloud.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private  AtomicLong longAdder = new AtomicLong(1);

    private ConcurrentHashMap<Long,User> userConcurrentHashMap = new ConcurrentHashMap<>();


    public User saveUser(User user){
        user.setId(longAdder.getAndIncrement());
        return userConcurrentHashMap.put(user.getId(),user) != null ? user : null;
    }


}
