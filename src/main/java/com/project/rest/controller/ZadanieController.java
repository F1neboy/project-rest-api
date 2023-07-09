package com.project.rest.controller;

import com.project.rest.model.User;
import com.project.rest.model.Zadanie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ZadanieController {

    ResponseEntity<Zadanie> addZadanie(@RequestBody Zadanie zadanie, @RequestHeader("Authorization") String token, @PathVariable Long id);

    ResponseEntity<Zadanie> editOsobaZadanie(@PathVariable Long id, @RequestBody User user);

    ResponseEntity<Zadanie> editStatusZadanie(@PathVariable Long id, @RequestBody Zadanie zadanie);

    ResponseEntity<Zadanie> editNazwaZadania(@PathVariable Long id, @RequestBody Zadanie zadanie);

    ResponseEntity<Zadanie> editOpisZadania(@PathVariable Long id, @RequestBody Zadanie zadanie);

    List<Zadanie> getAllZadaniaProjektu(@PathVariable Long id);
}
