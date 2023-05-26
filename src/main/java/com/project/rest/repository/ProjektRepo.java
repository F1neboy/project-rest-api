package com.project.rest.repository;

import com.project.rest.model.Projekt;
import com.project.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjektRepo extends JpaRepository<Projekt, Long> {
    List<Projekt> findProjektsByUserProject(Optional<User> user);

    Projekt findProjektById(Long id);


}
