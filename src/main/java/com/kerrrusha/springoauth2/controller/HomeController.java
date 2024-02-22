package com.kerrrusha.springoauth2.controller;

import com.kerrrusha.springoauth2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("users", userService.findAll());
        return "home";
    }
}

