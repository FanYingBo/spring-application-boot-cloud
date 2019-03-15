package com.study.selfs.gupao.springboot.restful.controller;

import com.study.selfs.gupao.springboot.restful.domain.User;
import com.study.selfs.gupao.springboot.restful.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/user/save")
    public boolean saveUser(@RequestBody  User user){
        return userService.save(user) != null;
    }

    @GetMapping(value = "/users/get")
    public Object query(int id){
        return userService.getUser(id);
    }
}
