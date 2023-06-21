package com.project.rest.service.Impl;

import com.project.rest.model.Projekt;
import com.project.rest.model.ProjektCooperators;
import com.project.rest.model.User;
import com.project.rest.repository.ProjektCooperatorsRepo;
import com.project.rest.repository.ProjektRepo;
import com.project.rest.repository.UserRepo;
import com.project.rest.service.ProjectCooperatorsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectCooperatorsServiceImpl implements ProjectCooperatorsService {


    private ProjektCooperatorsRepo projektCooperatorsRepo;

    private ProjektRepo projektRepo;

    private UserRepo userRepo;


    @Override
    public List<User> findUsersByProject(Long id) {
        Projekt projekt=projektRepo.findProjektById(id);
        List<ProjektCooperators> usersProj=projektCooperatorsRepo.findProjektCooperatorsByProjekt(Optional.ofNullable(projekt));
        List<User> users=usersProj.stream().map(projektCooperators -> projektCooperators.getUser()).toList();
        return users;
    }

    @Override
    public ProjektCooperators addUserToProject(ProjektCooperators projektCooperators) {
        Projekt projekt=projektRepo.findProjektById(projektCooperators.getProjekt().getId());
        User user=userRepo.findUserById(projektCooperators.getUser().getId());
        projektCooperators.setUser(user);
        projektCooperators.setProjekt(projekt);
        return projektCooperatorsRepo.save(projektCooperators);
    }

    @Override
    public List<ProjektCooperators> getAllCoop() {
        return projektCooperatorsRepo.findAll();
    }
}
