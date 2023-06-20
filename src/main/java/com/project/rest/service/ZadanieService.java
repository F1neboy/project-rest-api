package com.project.rest.service;

import com.project.rest.model.User;
import com.project.rest.model.Zadanie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZadanieService {

    ResponseEntity<Zadanie> editOsobaZadania(User user, Long id);

    ResponseEntity<Zadanie> editStatusZadania(Zadanie zadanie, Long id);

    ResponseEntity<Zadanie> editNazwaZadania(Zadanie zadanie, Long id);

    ResponseEntity<Zadanie> editOpisZadania(Zadanie zadanie, Long id);

    List<Zadanie> getAllZadaniaProjektu(Long id);

    Zadanie addZadanie(Zadanie zadanie, String token, Long id);
}
