package com.project.rest.controller.Impl;

import com.project.rest.config.JwtService;
import com.project.rest.controller.Controller;
import com.project.rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerImpl implements Controller {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/test1")
    @Override
    public String test1(@RequestHeader("Authorization") String token){
        String jwt=token.substring(7);
        return jwtService.extractEmail(jwt);
    }

}
