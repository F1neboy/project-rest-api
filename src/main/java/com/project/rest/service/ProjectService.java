package com.project.rest.service;

import com.project.rest.model.Projekt;
import com.project.rest.model.User;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Optional<Projekt> addNewProject(Projekt project, String token);

    Optional<List<Projekt>> findProjectsByUser(Optional<User> user);

    Optional<List<Projekt>> findProjectsByCoopUser(String token);

    Optional<List<Projekt>> findAllProjects();

    Projekt endProject(Long id);

    Projekt findProjectById(Long id);
}
