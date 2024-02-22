package com.kerrrusha.springoauth2.controller;

import com.kerrrusha.springoauth2.dto.user.request.UserRegisterRequestDto;
import com.kerrrusha.springoauth2.entity.User;
import com.kerrrusha.springoauth2.mapper.UserMapper;
import com.kerrrusha.springoauth2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
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

    @PostMapping("/logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        log.info("LOGGING OUT");
        logoutHandler.logout(request, response, authentication);
        return "redirect:./login";
    }
}
