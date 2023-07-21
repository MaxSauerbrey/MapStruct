package com.example.mapstruct.dto.response.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserResponseDTO {
    private Long id;
    private String email;
    private String name;
    private String lastName;
}
