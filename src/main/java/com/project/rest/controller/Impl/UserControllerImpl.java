package com.project.rest.controller.Impl;

import com.project.rest.controller.UserController;
import com.project.rest.model.User;
import com.project.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/usersToProject")
    @Override
    public Optional<List<User>> findUsersToProject(@RequestHeader("Authorization") String token){
        return userService.findAllToProject(token);
    }

    @GetMapping("/getUserData")
    @Override
    public User getUserData(@RequestHeader("Authorization") String token){
        return userService.getUserData(token);
    }

}
