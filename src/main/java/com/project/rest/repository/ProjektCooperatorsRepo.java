package com.project.rest.repository;

import com.project.rest.model.Projekt;
import com.project.rest.model.ProjektCooperators;
import com.project.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjektCooperatorsRepo extends JpaRepository<ProjektCooperators, Long> {
    List<ProjektCooperators> findProjektCooperatorsByProjekt(Optional<Projekt> projekt);

    List<ProjektCooperators> findProjektCooperatorsByUser(User user);

    List<ProjektCooperators> findAll();

}
