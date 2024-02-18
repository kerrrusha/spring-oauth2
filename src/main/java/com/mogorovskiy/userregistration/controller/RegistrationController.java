package com.mogorovskiy.userregistration.controller;

import com.mogorovskiy.userregistration.entity.*;
import com.mogorovskiy.userregistration.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {
    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") UserEntity userEntity, Model model) {
        userService.saveUser(userEntity);
        return "redirect:/login";
    }
}
