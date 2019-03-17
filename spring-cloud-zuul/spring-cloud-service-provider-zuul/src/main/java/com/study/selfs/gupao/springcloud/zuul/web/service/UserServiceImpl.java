package com.study.selfs.gupao.springcloud.zuul.web.service;

import com.study.selfs.gupao.springcloud.zuul.web.domain.User;
import com.study.selfs.gupao.springcloud.zuul.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
