package com.project.rest.service.Impl;

import com.project.rest.config.JwtService;
import com.project.rest.model.Projekt;
import com.project.rest.model.ProjektCooperators;
import com.project.rest.model.User;
import com.project.rest.repository.ProjektCooperatorsRepo;
import com.project.rest.repository.ProjektRepo;
import com.project.rest.repository.UserRepo;
import com.project.rest.service.ProjectService;
import com.project.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjektRepo projektRepo;

    private final UserRepo userRepo;

    private final JwtService jwtService;

    private final UserService userService;

    private final ProjektCooperatorsRepo projektCooperatorsRepo;

    @Override
    public Optional<Projekt> addNewProject(Projekt projekt, String token){
        String email=jwtService.extractEmail(token.substring(7));
        User user=userService.findUserByEmail(email).orElseThrow();
        projekt.setUserProject(user);
        return Optional.of(projektRepo.save(projekt));
    }

    @Override
    public Optional<List<Projekt>> findProjectsByUser(Optional<User> user) {
        return Optional.of(projektRepo.findProjektsByUserProject(user));
    }

    @Override
    public Optional<List<Projekt>> findProjectsByCoopUser(String token){
        User user=userRepo.findUserByEmail(jwtService.extractEmail(token.substring(7)));
        List<ProjektCooperators> coopList = projektCooperatorsRepo.findProjektCooperatorsByUser(user);
        List<Projekt> projectIds = coopList.stream().map(projektCooperators -> projektCooperators.getProjekt()).toList();
        return Optional.of(projectIds);
    }

    @Override
    public Optional<List<Projekt>> findAllProjects() {
        return Optional.of(projektRepo.findAll());
    }

    @Override
    public Projekt endProject(Long id) {
        Projekt projekt=projektRepo.findProjektById(id);
        projekt.setDataOddania(new Date());
        return projektRepo.save(projekt);
    }

    @Override
    public Projekt findProjectById(Long id) {
        return projektRepo.findProjektById(id);
    }

    @Override
    public void deleteProject(Long id) {
        projektRepo.deleteById(id);
    }

    @Override
    public Projekt editTitle(Long id, Projekt projekt) {
        Projekt projekt1 = projektRepo.getById(id);
        projekt1.setNazwa(projekt.getNazwa());
        return projektRepo.save(projekt1);
    }

    @Override
    public Projekt editDesc(Long id, Projekt projekt) {
        Projekt projekt1 = projektRepo.getById(id);
        projekt1.setOpis(projekt.getOpis());
        return projektRepo.save(projekt1);
    }


}
