package com.example.mapstruct.service.serviceImpl;

import com.example.mapstruct.dto.request.user.UserRegisterRequestDTO;
import com.example.mapstruct.dto.request.user.UserUpdateRequestDTO;
import com.example.mapstruct.dto.response.user.UserResponseDTO;
import com.example.mapstruct.mapper.UserMapper;
import com.example.mapstruct.model.User;
import com.example.mapstruct.repository.UserRepository;
import com.example.mapstruct.service.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);


    @Override
    public UserResponseDTO create(UserRegisterRequestDTO userRegisterRequestDTO) throws Exception {
        Optional<User> user = userRepository.findByEmail(userRegisterRequestDTO.getEmail());
        if(user.isPresent()) {
            throw new Exception ("El usuario ya existe");
        }
        User userEntity = mapper.userRegisterRequestDTOToUser(userRegisterRequestDTO);
        User savedEntity = userRepository.save(userEntity);
        return mapper.userToUserResponseDTO(savedEntity);
    }

    @Override
    public List<UserResponseDTO> list() {
        List <User> result = userRepository.findAllByActiveIsTrue();
        return result.stream()
                .map(u-> mapper.userToUserResponseDTO(u))
                        .collect(Collectors.toList());
    }

    private User findById(Long id) {

        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User no encontrado con id: " + id));
    }

    @Override
    public UserResponseDTO update(Long id, UserUpdateRequestDTO userUpdateRequestDTO) {
        User user = findById(id);
        user.setName(userUpdateRequestDTO.getName());
        user.setLastName(userUpdateRequestDTO.getLastName());
        user.setPassword(userUpdateRequestDTO.getPassword());
        userRepository.save(user);

        return mapper.userToUserResponseDTO(user);
    }


    @Override
    public void delete(Long id) {
        User user = findById(id);
        user.setActive(false);
        userRepository.save(user);
    }



    @Override
    public UserResponseDTO findByEmail(String email) {
        return null;
    }
}
