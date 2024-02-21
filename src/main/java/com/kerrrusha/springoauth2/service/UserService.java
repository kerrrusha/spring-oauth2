package com.kerrrusha.springoauth2.service;

import com.kerrrusha.springoauth2.entity.User;
import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();
}
