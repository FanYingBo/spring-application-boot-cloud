package com.study.selfs.gupao.springcloud.eureka.service.slave.provider.controller;


import com.study.selfs.gupao.springcloud.user.domain.User;
import com.study.selfs.gupao.springcloud.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class UserController {

    @Autowired
    private UserService userServiceImpl;


    @PostMapping("/user/save")
    public User save(@RequestBody User user){
        return userServiceImpl.save(user);
    }

    @GetMapping("/user/list")
    public Collection findAll(){
        return userServiceImpl.listUsers();
    }

}
