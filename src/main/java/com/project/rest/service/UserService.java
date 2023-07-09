package com.project.rest.service;

import com.project.rest.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByEmail(String email);

    Optional<List<User>> findAllToProject(String token, Long id);

    User findUserById(Long id);

    User getUserData(String token);
}
