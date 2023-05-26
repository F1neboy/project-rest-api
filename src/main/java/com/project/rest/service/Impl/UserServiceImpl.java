package com.project.rest.service.Impl;

import com.project.rest.model.User;
import com.project.rest.repository.UserRepo;
import com.project.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.of(userRepo.findByEmail(email).orElseThrow());
    }
}
