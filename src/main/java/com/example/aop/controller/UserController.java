package com.example.aop.controller;

import com.example.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser() {
        String name = "테스트";
        return userService.getUserInfo(name);
    }

    @GetMapping("/age")
    public String getAge() {
        int age = 20;
        return userService.getUserAge(age);
    }

}
