package com.example.mapstruct.controller;

import com.example.mapstruct.dto.request.user.UserRegisterRequestDTO;
import com.example.mapstruct.dto.request.user.UserUpdateRequestDTO;
import com.example.mapstruct.dto.response.user.UserResponseDTO;
import com.example.mapstruct.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        UserResponseDTO createdUser;
        try {
            createdUser = userService.create(userRegisterRequestDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.OK).body(createdUser);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserResponseDTO>> list(){
        List <UserResponseDTO> result = userService.list();

        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> update (@PathVariable Long id,@RequestBody UserUpdateRequestDTO userUpdateRequestDTO){
        UserResponseDTO result = null;
        try {
            result = userService.update(id, userUpdateRequestDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponseDTO> delete (@PathVariable Long id){
        userService.delete(id);

        return ResponseEntity.ok().build();
    }

}
