package com.study.selfs.gupao.springboot.restful.service;

import com.study.selfs.gupao.springboot.restful.domain.User;

public interface IUserService {

    public User save(User user);

    public User getUser(int id);
}
