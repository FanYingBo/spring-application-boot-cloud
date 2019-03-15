package com.study.selfs.gupao.springcloud.eureka.service.master.provider.service;

import com.study.selfs.gupao.springcloud.user.domain.User;
import com.study.selfs.gupao.springcloud.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static AtomicLong idGenerator = new AtomicLong();

    @Override
    public User save(User user) {
        user.setId(idGenerator.incrementAndGet());
        return userRepository.save(user);
    }

    @Override
    public Collection listUsers() {
        return userRepository.findAll();
    }
}
