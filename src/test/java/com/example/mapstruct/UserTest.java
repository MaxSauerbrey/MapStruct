package com.example.mapstruct;

import com.example.mapstruct.dto.request.user.UserRegisterRequestDTO;
import com.example.mapstruct.dto.response.user.UserResponseDTO;
import com.example.mapstruct.mapper.UserMapper;
import com.example.mapstruct.model.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void userMapperTest(){
        User user = new User();
        user.setId(1L);
        user.setName("Max");
        user.setLastName("Sauerbrey");
        user.setEmail("sauerbrey@gmail.com");
        user.setPassword("1234");

        UserResponseDTO userResponseDTO = mapper.userToUserResponseDTO(user);

        assertEquals(user.getName(), userResponseDTO.getName());
        System.out.println(user);
        System.out.println(userResponseDTO);
    }
}
