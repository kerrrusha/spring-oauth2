package com.kerrrusha.springoauth2.controller;

import com.kerrrusha.springoauth2.entity.User;
import com.kerrrusha.springoauth2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userRegisterDto", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userRegisterDto") User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
