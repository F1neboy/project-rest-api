package com.project.rest.repository;

import com.project.rest.model.Projekt;
import com.project.rest.model.Zadanie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZadanieRepo extends JpaRepository<Zadanie, Long> {
    Zadanie findZadanieByProjekt(Projekt projekt);
    Zadanie findZadanieById(Long id);
}
