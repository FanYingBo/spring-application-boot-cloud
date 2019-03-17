package com.study.selfs.gupao.springcloud.zuul.web.service;

import com.study.selfs.gupao.springcloud.zuul.web.domain.User;

import java.util.Collection;

public interface IUserService {

    public User save(User user);

    public Collection<User> findAll();
}
