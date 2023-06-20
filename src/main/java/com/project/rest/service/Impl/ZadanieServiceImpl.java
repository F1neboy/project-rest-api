package com.project.rest.service.Impl;

import com.project.rest.config.JwtService;
import com.project.rest.model.Projekt;
import com.project.rest.model.Status;
import com.project.rest.model.User;
import com.project.rest.model.Zadanie;
import com.project.rest.repository.ZadanieRepo;
import com.project.rest.service.ProjectService;
import com.project.rest.service.UserService;
import com.project.rest.service.ZadanieService;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ZadanieServiceImpl implements ZadanieService {

    private ZadanieRepo zadanieRepo;

    private UserService userService;

    private JwtService jwtService;

    private ProjectService projectService;

    @Override
    public ResponseEntity<Zadanie> editOsobaZadania(User user, Long id){
        user=userService.findUserById(user.getId());
        Zadanie zadanie=zadanieRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Zadanie nie znalezione"));
        zadanie.setUserDo(user);
        zadanieRepo.save(zadanie);
        return ResponseEntity.ok(zadanie);
    }

    @Override
    public ResponseEntity<Zadanie> editStatusZadania(Zadanie zadanie, Long id){
        Zadanie zadanieNew=zadanieRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Zadanie nie znalezione"));
        zadanieNew.setStatus(zadanie.getStatus());
        zadanieRepo.save(zadanieNew);
        return ResponseEntity.ok(zadanieNew);
    }
    @Override
    public ResponseEntity<Zadanie> editNazwaZadania(Zadanie zadanie, Long id){
        Zadanie zadanieNew=zadanieRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Zadanie nie znalezione"));
        zadanieNew.setNazwa(zadanie.getNazwa());
        zadanieRepo.save(zadanieNew);
        return ResponseEntity.ok(zadanieNew);
    }
    @Override
    public ResponseEntity<Zadanie> editOpisZadania(Zadanie zadanie, Long id){
        Zadanie zadanieNew=zadanieRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Zadanie nie znalezione"));
        zadanieNew.setOpis(zadanie.getOpis());
        zadanieRepo.save(zadanieNew);
        return ResponseEntity.ok(zadanieNew);
    }

    @Override
    public List<Zadanie> getAllZadaniaProjektu(Long id){
        Projekt projekt=projectService.findProjectById(id);
        return zadanieRepo.findZadaniesByProjekt(projekt);
    }

    @Override
    public Zadanie addZadanie(Zadanie zadanie, String token, Long id){
        String email=jwtService.extractEmail(token.substring(7));
        User user=userService.findUserByEmail(email).orElseThrow();
        Projekt projekt=projectService.findProjectById(id);
        zadanie.setUserCreate(user);
        zadanie.setProjekt(projekt);
        zadanie.setStatus(Status.DO_ZROBIENIA);
        return zadanieRepo.save(zadanie);
    }

}
