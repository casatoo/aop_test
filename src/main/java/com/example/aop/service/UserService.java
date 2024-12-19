package com.example.aop.service;

import com.example.aop.annotation.ClassAOP;
import org.springframework.stereotype.Service;

@Service
@ClassAOP
public class UserService {

    public String getUserInfo(String name) {
        return "User Info: " + name;
    }

    public String getUserAge(int age) {
        return "User Age : " + age;
    }
}