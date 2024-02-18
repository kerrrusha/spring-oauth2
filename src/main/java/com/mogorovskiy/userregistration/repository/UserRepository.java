package com.mogorovskiy.userregistration.repository;

import com.mogorovskiy.userregistration.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
