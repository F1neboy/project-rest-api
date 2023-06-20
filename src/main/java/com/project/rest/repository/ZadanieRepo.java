package com.project.rest.repository;

import com.project.rest.model.Projekt;
import com.project.rest.model.Zadanie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZadanieRepo extends JpaRepository<Zadanie, Long> {
    Zadanie findZadanieById(Long id);

    List<Zadanie> findZadaniesByProjekt(Projekt projekt);
}
