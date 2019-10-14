package com.laoli.redisDemo.controller;

import com.laoli.commons.beans.User;
import com.laoli.redisDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String words(){
        return "hello";
    }


    @GetMapping("users")
    public List<User> gerAllUsers(){

        List<User> users=userService.getUsers();
        return users;
    }
}
