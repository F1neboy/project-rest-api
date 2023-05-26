package com.project.rest.controller;

import org.springframework.web.bind.annotation.RequestHeader;


public interface Controller {


    public String test1(@RequestHeader("Authorization") String token);

}
