package com.study.selfs.gupao.springcloud.zookeeper.server.master.service;

import com.study.selfs.gupao.springcloud.user.domain.User;
import com.study.selfs.gupao.springcloud.user.domain.UserService;
import com.study.selfs.gupao.springcloud.zookeeper.server.master.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public Collection listUsers() {
        return null;
    }
}
