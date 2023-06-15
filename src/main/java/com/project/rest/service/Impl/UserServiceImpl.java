package com.project.rest.service.Impl;

import com.project.rest.config.JwtService;
import com.project.rest.model.User;
import com.project.rest.repository.UserRepo;
import com.project.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;


    private final JwtService jwtService;

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.of(userRepo.findByEmail(email).orElseThrow());
    }
    @Override
    public Optional<List<User>> findAllToProject(String token){
        String usrEmail=jwtService.extractEmail(token.substring(7));
        List<User> user=userRepo.findAll();
        user=user.stream().filter(m->!m.getEmail().equals(usrEmail)).toList();
        return Optional.of(user);
    }
}
