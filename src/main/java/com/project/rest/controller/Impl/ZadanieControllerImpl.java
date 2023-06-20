package com.project.rest.controller.Impl;

import com.project.rest.controller.ZadanieController;
import com.project.rest.model.User;
import com.project.rest.model.Zadanie;
import com.project.rest.repository.ZadanieRepo;
import com.project.rest.service.ZadanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ZadanieControllerImpl implements ZadanieController {

    @Autowired
    private ZadanieService zadanieService;

    @Autowired
    private ZadanieRepo zadanieRepo;

    @PostMapping("/addZadanie/{id}")
    @Override
    public ResponseEntity<Zadanie> addZadanie(@RequestBody Zadanie zadanie, @RequestHeader("Authorization") String token, @PathVariable Long id){
        return ResponseEntity.ok(zadanieService.addZadanie(zadanie, token, id));
    }

    @PutMapping("/editOsobaZadania/{id}")
    @Override
    public ResponseEntity<Zadanie> editOsobaZadanie(@PathVariable Long id, @RequestBody User user){
        return zadanieService.editOsobaZadania(user, id);
    }


    @PutMapping("/editStatusZadania/{id}")
    @Override
    public ResponseEntity<Zadanie> editStatusZadanie(@PathVariable Long id, @RequestBody Zadanie zadanie){
        return zadanieService.editStatusZadania(zadanie, id);
    }

    @PutMapping("/editNazwaZadania/{id}")
    @Override
    public ResponseEntity<Zadanie> editNazwaZadania(@PathVariable Long id, @RequestBody Zadanie zadanie){
        return zadanieService.editNazwaZadania(zadanie, id);
    }

    @PutMapping("/editOpisZadania/{id}")
    @Override
    public ResponseEntity<Zadanie> editOpisZadania(@PathVariable Long id, @RequestBody Zadanie zadanie){
        return zadanieService.editOpisZadania(zadanie, id);
    }

    @GetMapping("/getAllZadaniaProjektu/{id}")
    @Override
    public List<Zadanie> getAllZadaniaProjektu(@PathVariable Long id){
        return zadanieService.getAllZadaniaProjektu(id);
    }
}
