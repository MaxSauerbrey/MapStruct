package com.example.mapstruct.dto.request.user;

import lombok.Data;

@Data
public class UserUpdateRequestDTO {
    private String name;
    private String lastName;
    private String password;
}
