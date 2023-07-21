package com.example.mapstruct.service.service;

import com.example.mapstruct.dto.request.user.UserRegisterRequestDTO;
import com.example.mapstruct.dto.request.user.UserUpdateRequestDTO;
import com.example.mapstruct.dto.response.user.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO findByEmail(String email);
    UserResponseDTO create(UserRegisterRequestDTO userRegisterRequestDTO) throws Exception;
    List<UserResponseDTO> list();
    UserResponseDTO update(Long id, UserUpdateRequestDTO userUpdateRequestDTO) throws Exception;
    void delete(Long id);
}
