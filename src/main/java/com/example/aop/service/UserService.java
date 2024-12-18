package com.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserInfo(String name) {
        return "User Info: " + name;
    }
}