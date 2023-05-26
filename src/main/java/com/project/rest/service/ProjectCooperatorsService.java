package com.project.rest.service;

import com.project.rest.model.ProjektCooperators;
import com.project.rest.model.User;

import java.util.List;
import java.util.Optional;

public interface ProjectCooperatorsService {

    List<User> findUsersByProject(Long id);

    ProjektCooperators addUserToProject(ProjektCooperators projektCooperators);

    List<ProjektCooperators> getAllCoop();
}
