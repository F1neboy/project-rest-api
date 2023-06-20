package com.project.rest.controller;

import com.project.rest.model.User;
import com.project.rest.model.Zadanie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ZadanieController {

    @PostMapping("/addZadanie/{id}")
    ResponseEntity<Zadanie> addZadanie(@RequestBody Zadanie zadanie, @RequestHeader("Authorization") String token, @PathVariable Long id);

    @PutMapping("/editOsobaZadania/{id}")
    ResponseEntity<Zadanie> editOsobaZadanie(@PathVariable Long id, @RequestBody User user);

    @PutMapping("/editStatusZadania/{id}")
    ResponseEntity<Zadanie> editStatusZadanie(@PathVariable Long id, @RequestBody Zadanie zadanie);

    @PutMapping("/editNazwaZadania/{id}")
    ResponseEntity<Zadanie> editNazwaZadania(@PathVariable Long id, @RequestBody Zadanie zadanie);

    @PutMapping("/editOpisZadania/{id}")
    ResponseEntity<Zadanie> editOpisZadania(@PathVariable Long id, @RequestBody Zadanie zadanie);

    @GetMapping("/getAllZadaniaProjektu/{id}")
    List<Zadanie> getAllZadaniaProjektu(@PathVariable Long id);
}
