package com.project.rest.controller.Impl;

import com.project.rest.auth.AuthenticationRequest;
import com.project.rest.auth.AuthenticationResponse;
import com.project.rest.auth.AuthenticationService;
import com.project.rest.auth.ReqisterRequest;
import com.project.rest.controller.AuthController;
import com.project.rest.model.User;
import com.project.rest.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    @Override
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody ReqisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/test")
    @Override
    public String test1(){
        return "Nie zabezpieczony endpoint";
    }

    @GetMapping("/all")
    @Override
    public List<User> all(){ return userRepo.findAll(); }

}
