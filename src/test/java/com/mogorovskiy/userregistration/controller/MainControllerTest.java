package com.mogorovskiy.userregistration.controller;

import com.mogorovskiy.userregistration.entity.UserEntity;
import com.mogorovskiy.userregistration.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MainControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private MainController mainController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMain() {
        // Arrange
        Model model = Mockito.mock(Model.class);
        List<UserEntity> users = Arrays.asList(
                new UserEntity(1L, "John Doe", "john@example.com", "password1"),
                new UserEntity(2L, "Jane Doe", "jane@example.com", "password2")
        );
        when(userService.getAll()).thenReturn(users);

        // Act
        String viewName = mainController.main(model);

        // Assert
        assertEquals("main", viewName);
        verify(model).addAttribute("users", users);
        verify(userService).getAll();
    }

    @Test
    void testLogin() {
        // Act
        String viewName = mainController.login();

        // Assert
        assertEquals("login", viewName);
    }
}
