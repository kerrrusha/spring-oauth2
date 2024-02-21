package com.kerrrusha.springoauth2.controller;

import com.kerrrusha.springoauth2.dto.user.request.UserRegisterRequestDto;
import com.kerrrusha.springoauth2.entity.User;
import com.kerrrusha.springoauth2.mapper.UserMapper;
import com.kerrrusha.springoauth2.service.UserService;
import jakarta.validation.Valid;
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
    private final UserMapper userMapper;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegisterRequestDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") UserRegisterRequestDto userRegisterDto) {
        User user = userMapper.toEntity(userRegisterDto);
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
