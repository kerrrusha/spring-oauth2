package com.mogorovskiy.userregistration.security;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.web.*;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
    UserDetailsServiceImpl userDetailsService;

    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(encoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requsts) -> requsts
                        .requestMatchers("/registration").permitAll()
                        .anyRequest().authenticated())
                        .formLogin((form) -> form.loginPage("/login")
                        .permitAll()).logout(LogoutConfigurer::permitAll);
        return httpSecurity.build();
    }
}
