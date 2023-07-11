package com.project.rest.controller;

import com.project.rest.auth.AuthenticationRequest;
import com.project.rest.auth.AuthenticationResponse;
import com.project.rest.auth.ReqisterRequest;
import com.project.rest.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface AuthController {

    public ResponseEntity<AuthenticationResponse> register (@RequestBody ReqisterRequest request);

    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request);

    public String test1();

}
