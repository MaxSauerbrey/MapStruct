package com.example.mapstruct.mapper;


import com.example.mapstruct.dto.request.user.UserRegisterRequestDTO;

import com.example.mapstruct.dto.response.user.UserResponseDTO;
import com.example.mapstruct.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "name", source = "userName")
    User userRegisterRequestDTOToUser (UserRegisterRequestDTO userRegisterRequest);

    UserResponseDTO userToUserResponseDTO (User user);
}
