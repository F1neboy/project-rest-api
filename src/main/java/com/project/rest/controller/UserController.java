package com.project.rest.controller;

import com.project.rest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserController {

    Optional<List<User>> findUsersToProject(@RequestHeader("Authorization") String token, @PathVariable Long id);

    User getUserData(@RequestHeader("Authorization") String token);
}
