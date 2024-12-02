package com.easybid.user;

import com.easybid.user.dto.CreateUserDTO;
import com.easybid.user.dto.UpdateUserDTO;
import com.easybid.user.dto.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

  UserResponseDTO createUser(CreateUserDTO createUserDTO);

  UserResponseDTO updateUser(UUID userId, UpdateUserDTO updateUserDTO);

  UserResponseDTO getUserById(UUID userId);

  List<UserResponseDTO> getAllUsers();

  void deleteUser(UUID userId);
}
