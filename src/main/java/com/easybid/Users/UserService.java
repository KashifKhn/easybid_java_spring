package com.easybid.Users;

import com.easybid.Users.dto.CreateUserDTO;
import com.easybid.Users.dto.UpdateUserDTO;
import com.easybid.Users.dto.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

  UserResponseDTO createUser(CreateUserDTO createUserDTO);

  UserResponseDTO updateUser(UUID userId, UpdateUserDTO updateUserDTO);

  UserResponseDTO getUserById(UUID userId);

  List<UserResponseDTO> getAllUsers();

  void deleteUser(UUID userId);
}
