package com.project.rest.controller;

import com.project.rest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

public interface UserController {
    @GetMapping("/usersToProject")
    Optional<List<User>> findUsersToProject(@RequestHeader("Authorization") String token);

    @GetMapping("/getUserData")
    User getUserData(@RequestHeader("Authorization") String token);
}
