package com.study.selfs.gupao.springcloud.service.consumer.controller;


import com.study.selfs.gupao.springcloud.user.domain.User;
import com.study.selfs.gupao.springcloud.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {


    @Autowired
    private UserService proxyUserService;

    @GetMapping("/user/add")
    public boolean add(@RequestParam("name") String name){
        User user = new User();
        user.setName(name);
        return proxyUserService.save(user) != null;
    }

    @GetMapping("/user/list")
    public Collection findAllUser(){
        return proxyUserService.listUsers();
    }
}
