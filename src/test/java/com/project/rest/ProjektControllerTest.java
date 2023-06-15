package com.project.rest;
/*
import com.project.rest.controller.Impl.ProjektControllerImpl;
import com.project.rest.controller.ProjektController;
import com.project.rest.model.Projekt;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjektControllerTest {

    private final ProjektController projektController = new ProjektControllerImpl();

    @Test
    void testGetCreatedProjects() {
        // Arrange
        String token = "testToken";

        // Act
        Optional<List<Projekt>> result = projektController.getCreatedProjects(token);

        // Assert
        assertTrue(result.isPresent());
        // Dodaj dalsze asercje w zależności od oczekiwanego wyniku
    }

    @Test
    void testGetProjectById() {
        // Arrange
        Long id = 1L;

        // Act
        Optional<Projekt> result = projektController.getProjectById(id);

        // Assert
        assertTrue(result.isPresent());
        // Dodaj dalsze asercje w zależności od oczekiwanego wyniku
    }

    @Test
    void testGetCoopProjects() {
        // Arrange
        String token = "testToken";

        // Act
        Optional<Optional<List<Projekt>>> result = projektController.getCoopProjects(token);

        // Assert
        assertTrue(result.isPresent());
        // Dodaj dalsze asercje w zależności od oczekiwanego wyniku
    }

    @Test
    void testAddProject() {
        // Arrange
        String token = "testToken";
        Projekt projekt = new Projekt();

        // Act
        ResponseEntity<Optional<Projekt>> result = projektController.addProject(token, projekt);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody().isPresent());
        // Dodaj dalsze asercje w zależności od oczekiwanego wyniku
    }

    // Dodaj dalsze testy dla pozostałych metod

}
*/