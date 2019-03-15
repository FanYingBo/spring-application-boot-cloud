package com.study.selfs.gupao.springboot.restful.repository;


import com.study.selfs.gupao.springboot.restful.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private ConcurrentHashMap<Integer,User> users = new ConcurrentHashMap<>();

    private AtomicInteger atomicInteger = new AtomicInteger();

    public boolean save(User user){
        int index = atomicInteger.getAndIncrement();
        user.setId(index);
        return users.put(index, user) == null;
    }

    public User getUsers(Integer id) {
        return users.get(id);
    }
}
