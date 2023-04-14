package com.project.rest.controller;

import com.project.rest.auth.AuthenticationRequest;
import com.project.rest.auth.AuthenticationResponse;
import com.project.rest.auth.AuthenticationService;
import com.project.rest.auth.ReqisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody ReqisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/test")
    public String test1(){
        return "Nie zabezpieczony endpoint";
    }

}
