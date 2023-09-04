package com.project.rest;
import com.project.rest.model.User;
import com.project.rest.repository.UserRepo;
import com.project.rest.service.Impl.UserServiceImpl;
import com.project.rest.service.ProjectCooperatorsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepo;


    @Mock
    private ProjectCooperatorsService projectCooperatorsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindUserByEmail() {
        User user = new User();
        when(userRepo.findByEmail(anyString())).thenReturn(Optional.of(user));

        Optional<User> result = userService.findUserByEmail("test@email.com");
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testFindUserById() {
        User user = new User();
        when(userRepo.findById(anyLong())).thenReturn(Optional.of(user));
        User result = userService.findUserById(1L);
        assertEquals(user, result);
    }

}