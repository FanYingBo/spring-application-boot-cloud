package com.study.selfs.gupao.springcloud.zuul.web.controller;

import com.study.selfs.gupao.springcloud.zuul.web.domain.User;
import com.study.selfs.gupao.springcloud.zuul.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Random;

@RestController
public class UserController {
    private static Random ran = new Random();

    @Autowired
    private IUserService userService;

    @PostMapping("/user/save")
    public User save(@RequestBody User user){
        int i = ran.nextInt(200);
        try {
            System.out.println("thread sleep: "+i+" ms");
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.save(user);
    }

    @GetMapping("/user/get")
    public Collection findAll(){
        return userService.findAll();
    }
}
