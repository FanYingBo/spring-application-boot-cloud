package com.study.selfs.gupao.springcloud.zookeeper.server.master.controller;


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
    private UserService userService;

    @PostMapping("/zk/server/user/save")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/zk/server/user/list")
    public Collection getUsers(){
        return userService.listUsers();
    }
}
