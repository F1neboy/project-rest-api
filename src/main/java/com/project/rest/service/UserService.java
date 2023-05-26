package com.project.rest.service;

import com.project.rest.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByEmail(String email);
}
