package com.project.rest;


import com.project.rest.config.JwtService;
import com.project.rest.model.*;
import com.project.rest.repository.ZadanieRepo;
import com.project.rest.service.Impl.ZadanieServiceImpl;
import com.project.rest.service.ProjectService;
import com.project.rest.service.UserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ZadanieServiceImplTest {

    @InjectMocks
    private ZadanieServiceImpl zadanieService;

    @Mock
    private ZadanieRepo zadanieRepo;

    @Mock
    private UserService userService;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testEditOsobaZadania() {
        User mockUser = new User();
        mockUser.setId(1L);
        when(userService.findUserById(anyLong())).thenReturn(mockUser);
        Zadanie mockZadanie = new Zadanie();
        when(zadanieRepo.findById(anyLong())).thenReturn(Optional.of(mockZadanie));

        zadanieService.editOsobaZadania(mockUser, 1L);

        assertEquals(mockUser, mockZadanie.getUserDo());
    }

    @Test
    void testEditStatusZadania() {
        Zadanie inputZadanie = new Zadanie();
        inputZadanie.setStatus(Status.W_TRAKCIE);
        Zadanie storedZadanie = new Zadanie();
        when(zadanieRepo.findById(anyLong())).thenReturn(Optional.of(storedZadanie));

        zadanieService.editStatusZadania(inputZadanie, 1L);

        assertEquals(Status.W_TRAKCIE, storedZadanie.getStatus());
    }

    @Test
    void testEditNazwaZadania() {
        Zadanie inputZadanie = new Zadanie();
        inputZadanie.setNazwa("TestNazwa");
        Zadanie storedZadanie = new Zadanie();
        when(zadanieRepo.findById(anyLong())).thenReturn(Optional.of(storedZadanie));

        zadanieService.editNazwaZadania(inputZadanie, 1L);

        assertEquals("TestNazwa", storedZadanie.getNazwa());
    }

    @Test
    void testEditOpisZadania() {
        Zadanie inputZadanie = new Zadanie();
        inputZadanie.setOpis("TestOpis");
        Zadanie storedZadanie = new Zadanie();
        when(zadanieRepo.findById(anyLong())).thenReturn(Optional.of(storedZadanie));

        zadanieService.editOpisZadania(inputZadanie, 1L);

        assertEquals("TestOpis", storedZadanie.getOpis());
    }

    @Test
    void testResourceNotFoundException() {
        when(zadanieRepo.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            zadanieService.editOpisZadania(new Zadanie(), 1L);
        });
    }

}
