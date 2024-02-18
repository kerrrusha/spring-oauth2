package com.mogorovskiy.userregistration.service;

import com.mogorovskiy.userregistration.entity.*;
import com.mogorovskiy.userregistration.repository.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }
}
