package com.project.rest.controller.Impl;

import com.project.rest.config.JwtService;
import com.project.rest.controller.ProjektController;
import com.project.rest.model.Projekt;
import com.project.rest.model.ProjektCooperators;
import com.project.rest.model.User;
import com.project.rest.service.ProjectCooperatorsService;
import com.project.rest.service.ProjectService;
import com.project.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjektControllerImpl implements ProjektController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectCooperatorsService projectCooperatorsService;



    @GetMapping("/createdProjects")
    @Override
    public Optional<List<Projekt>> getCreatedProjects(@RequestHeader("Authorization") String token){
        String email=jwtService.extractEmail(token.substring(7));
        Optional<User> user=userService.findUserByEmail(email);
        return projectService.findProjectsByUser(user);
    }

    @GetMapping("/coopProjects")
    @Override
    public Optional<Optional<List<Projekt>>> getCoopProjects(@RequestHeader("Authorization") String token){
        return Optional.ofNullable(projectService.findProjectsByCoopUser(token));
    }

    @PostMapping("/addProject")
    @Override
    public ResponseEntity<Optional<Projekt>> addProject(@RequestHeader("Authorization") String token, @RequestBody Projekt projekt){
        return ResponseEntity.ok(projectService.addNewProject(projekt, token));
    }
    @GetMapping("/allProjects")
    @Override
    public Optional<List<Projekt>> getAllProjects(){
        return projectService.findAllProjects();
    }

    @PatchMapping("/endProject/{id}")
    @Override
    public Optional<Projekt> endProject(@PathVariable Long id){
        return projectService.endProject(id);
    }

    @PostMapping("/addCoopUser")
    @Override
    public ResponseEntity<ProjektCooperators> addUserToProject2(@RequestBody ProjektCooperators projektCooperators){
        return ResponseEntity.ok(projectCooperatorsService.addUserToProject(projektCooperators));
    }

    @GetMapping("/allCoop")
    @Override
    public ResponseEntity<List<ProjektCooperators>> getAllCoop(){
        return ResponseEntity.ok(projectCooperatorsService.getAllCoop());
    }

    @GetMapping("/projectCoop/{id}")
    @Override
    public ResponseEntity<List<User>> getProjectCoop(@PathVariable Long id){
        return ResponseEntity.ok(projectCooperatorsService.findUsersByProject(id));
    }

}
