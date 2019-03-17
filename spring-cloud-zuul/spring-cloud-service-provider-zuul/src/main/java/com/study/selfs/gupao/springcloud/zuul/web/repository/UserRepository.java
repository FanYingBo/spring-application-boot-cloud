package com.study.selfs.gupao.springcloud.zuul.web.repository;

import com.study.selfs.gupao.springcloud.zuul.web.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private ConcurrentHashMap<Integer,User> users = new ConcurrentHashMap<>();

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public User save(User user){
        int id = atomicInteger.getAndIncrement();
        user.setId(id);
        return users.put(id,user) != null ? new User() : user;
    }

    public Collection<User> findAll(){
        return users.values();
    }
}
