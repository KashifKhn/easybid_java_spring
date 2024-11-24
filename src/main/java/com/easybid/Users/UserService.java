package com.easybid.Users;

import org.springframework.http.ResponseEntity;

import com.easybid.Users.dto.CreateUserDTO;
import com.easybid.Users.dto.UpdateUserDTO;
import com.easybid.Users.dto.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

  ResponseEntity<UserResponseDTO> createUser(CreateUserDTO createUserDTO);

  ResponseEntity<UserResponseDTO> updateUser(UUID userId, UpdateUserDTO updateUserDTO);

  ResponseEntity<UserResponseDTO> getUserById(UUID userId);

  ResponseEntity<List<UserResponseDTO>> getAllUsers();

  ResponseEntity<UserResponseDTO> deleteUser(UUID userId);
}
