package com.study.selfs.gupao.springboot.restful.service;


import com.study.selfs.gupao.springboot.restful.domain.User;
import com.study.selfs.gupao.springboot.restful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user) ? null : user;
    }

    @Override
    public User getUser(int id) {
        return userRepository.getUsers(id);
    }


}
