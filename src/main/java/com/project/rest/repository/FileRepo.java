package com.project.rest.repository;

import com.project.rest.model.File;
import com.project.rest.model.Projekt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepo extends JpaRepository<File, Long> {

    List<File> getByProjekt(Projekt projekt);
}
