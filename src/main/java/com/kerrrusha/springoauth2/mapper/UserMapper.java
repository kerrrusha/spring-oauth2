package com.kerrrusha.springoauth2.mapper;

import com.kerrrusha.springoauth2.config.MapperConfig;
import com.kerrrusha.springoauth2.dto.user.request.UserRegisterRequestDto;
import com.kerrrusha.springoauth2.entity.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toEntity(UserRegisterRequestDto user);
}
