package com.mogorovskiy.userregistration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.mogorovskiy.userregistration.entity.UserEntity;
import com.mogorovskiy.userregistration.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

class RegistrationControllerTest {

    @Test
    void testRegistration_GetMapping() {
        UserService userService = mock(UserService.class);
        RegistrationController registrationController = new RegistrationController(userService);
        Model model = mock(Model.class);
        String viewName = registrationController.registration(model);
        assertEquals("registration", viewName);
        verify(model).addAttribute(eq("userEntity"), any());
    }

    @Test
    void testRegistration_PostMapping() {
        UserService userService = mock(UserService.class);
        RegistrationController registrationController = new RegistrationController(userService);
        Model model = mock(Model.class);
        UserEntity userEntity = new UserEntity();
        String redirectUrl = registrationController.registration(userEntity, model);
        assertEquals("redirect:/login", redirectUrl);
        verify(userService).saveUser(userEntity);
    }
}