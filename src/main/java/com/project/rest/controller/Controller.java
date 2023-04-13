package com.project.rest.controller;

import com.project.rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private UserRepo userRepo;
}
