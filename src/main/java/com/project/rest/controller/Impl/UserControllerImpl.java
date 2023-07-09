package com.project.rest.controller.Impl;

import com.project.rest.controller.UserController;
import com.project.rest.model.User;
import com.project.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/usersToProject/{id}")
    @Override
    public Optional<List<User>> findUsersToProject(@RequestHeader("Authorization") String token, @PathVariable Long id){
        return userService.findAllToProject(token, id);
    }

    @GetMapping("/getUserData")
    @Override
    public User getUserData(@RequestHeader("Authorization") String token){
        return userService.getUserData(token);
    }

}
