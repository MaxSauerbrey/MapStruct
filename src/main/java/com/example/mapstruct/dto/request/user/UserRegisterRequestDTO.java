package com.example.mapstruct.dto.request.user;

import lombok.Data;

@Data
public class UserRegisterRequestDTO {
    private String email;
    private String userName;
    private String lastName;
    private String password;
}
