package com.project.rest.service.Impl;

import com.project.rest.config.JwtService;
import com.project.rest.model.User;
import com.project.rest.repository.UserRepo;
import com.project.rest.service.ProjectCooperatorsService;
import com.project.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final JwtService jwtService;

    private final ProjectCooperatorsService projectCooperatorsService;

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.of(userRepo.findByEmail(email).orElseThrow());
    }
    @Override
    public Optional<List<User>> findAllToProject(String token, Long id){
        String usrEmail=jwtService.extractEmail(token.substring(7));
        List<User> user=userRepo.findAll();
        List<String> usersInProject=projectCooperatorsService.findUsersByProject(id).stream().filter(Objects::nonNull).map(n->n.getEmail()).toList();
        user=user.stream().filter(m->!m.getEmail().equals(usrEmail)).toList();
        for(String n: usersInProject){
            user=user.stream().filter(m->!m.getEmail().equals(n)).toList();
        }
        return Optional.of(user);
    }
    @Override
    public User findUserById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User nie znaleziony"));
    }

    @Override
    public User getUserData(String token){
        String usrEmail=jwtService.extractEmail(token.substring(7));
        User user = userRepo.findUserByEmail(usrEmail);
        return user;

    }
}
