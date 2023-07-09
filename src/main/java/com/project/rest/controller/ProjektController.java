package com.project.rest.controller;

import com.project.rest.model.Projekt;
import com.project.rest.model.ProjektCooperators;
import com.project.rest.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

public interface ProjektController {

    Optional<List<Projekt>> getCreatedProjects(@RequestHeader("Authorization") String token);

    Projekt getProjectById(@PathVariable Long id);

    Optional<Optional<List<Projekt>>> getCoopProjects(@RequestHeader("Authorization") String token);

    public ResponseEntity<Optional<Projekt>> addProject(@RequestHeader("Authorization") String token, @RequestBody Projekt projekt);

    public Optional<List<Projekt>> getAllProjects();

    public Projekt endProject(@PathVariable Long id);

    public ResponseEntity<ProjektCooperators> addUserToProject2(@RequestBody ProjektCooperators projektCooperators);

    public ResponseEntity<List<ProjektCooperators>> getAllCoop();

    public ResponseEntity<List<User>> getProjectCoop(@PathVariable Long id);

    ResponseEntity<Projekt> editProjektTitle(@PathVariable Long id, @RequestBody Projekt projekt);

    ResponseEntity<Projekt> editProjektDesc(@PathVariable Long id, @RequestBody Projekt projekt);

    void deleteProject(@PathVariable Long id);
}
