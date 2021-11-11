package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.User;
import com.generation.SpringSecurityJWT.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;


class UserControllerTest {
    @Test
    @DisplayName("Pruebas UserController save")
    void saveTest(){
        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);

        UserController userController = new UserController(userService,bCryptPasswordEncoder);
        User user = new User();

        user.setName("Diana");
        user.setUsername("diana@gmail.com");
        user.setPassword("12345");

        when (userService.save(any(User.class))).thenReturn(user);

        User response = userController.save(user);

        verify(userService, times(1)).save(any(User.class));
        assertEquals(user.getName(), response.getName());

    }
    @Test
    @DisplayName("Pruebas UserController save")
    void getUserTest(){
        //Verificar llamar servicio

        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);

        UserController userController = new UserController(userService,bCryptPasswordEncoder);

        User user = new User();
        user.setName("Diana");
        user.setUsername("diana@gmail.com");
        user.setPassword("12345");

        when (userService.save(any(User.class))).thenReturn(user);

        User result = userController.getUser(user.getId());

        verify(userService, times(1)).getUser(user.getId());
        assertEquals(user.getId(), result.getId());
    }



}