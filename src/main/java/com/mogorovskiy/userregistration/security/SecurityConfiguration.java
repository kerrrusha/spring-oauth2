package com.mogorovskiy.userregistration.security;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.*;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requsts) -> requsts
                .requestMatchers("/registration").permitAll()
                .anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login")
                .permitAll()).logout((logout) -> logout.permitAll());
        return httpSecurity.build();
    }
}
