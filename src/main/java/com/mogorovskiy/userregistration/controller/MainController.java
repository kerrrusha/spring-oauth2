package com.mogorovskiy.userregistration.controller;

import com.mogorovskiy.userregistration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("users", userService.getAll());
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

