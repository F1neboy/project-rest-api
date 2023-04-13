package com.project.rest.controller;

import com.project.rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
}
