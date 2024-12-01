package com.easybid.Users;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.easybid.Users.dto.CreateUserDTO;
import com.easybid.Users.dto.UpdateUserDTO;
import com.easybid.Users.dto.UserResponseDTO;
import com.easybid.auth.PasswordHasher;
import com.easybid.exceptions.DataConflictException;
import com.easybid.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordHasher passwordHasher;

  public UserServiceImpl(final UserRepository userRepository, final PasswordHasher passwordHasher) {
    this.userRepository = userRepository;
    this.passwordHasher = passwordHasher;
  }

  @Override
  public UserResponseDTO createUser(final CreateUserDTO createUserDTO) {
    if (userRepository.findByEmail(createUserDTO.getEmail()).isPresent()) {
      throw new DataConflictException("Email already exists: " + createUserDTO.getEmail());
    }
    final UserEntity userEntity = new UserEntity();
    userEntity.setName(createUserDTO.getName());
    String hashPassword = this.passwordHasher.hash(createUserDTO.getPassword());
    userEntity.setHashPassword(hashPassword);
    userEntity.setAddress(createUserDTO.getAddress());
    userEntity.setEmail(createUserDTO.getEmail());
    userEntity.setPhoneNumber(createUserDTO.getPhoneNumber());
    userEntity.setRole(createUserDTO.getRole());
    this.userRepository.save(userEntity);
    return convertUserToUserResponseDTO(userEntity);
  }

  @Override
  public UserResponseDTO updateUser(final UUID userId, final UpdateUserDTO updateUserDTO) {
    final UserEntity user = this.findUserById(userId);
    System.out.println("befor: " + user.getHashPassword());
    user.updateFromDTO(updateUserDTO, this.passwordHasher);
    this.userRepository.save(user);
    System.out.println("after : " + user.getHashPassword());
    return convertUserToUserResponseDTO(user);
  }

  @Override
  public UserResponseDTO getUserById(final UUID userId) {
    final UserResponseDTO responseDTO = convertUserToUserResponseDTO(findUserById(userId));
    return responseDTO;
  }

  @Override
  public List<UserResponseDTO> getAllUsers() {
    final List<UserEntity> users = this.userRepository.findAllActiveUsers();
    final List<UserResponseDTO> responseDTOs = users.stream()
        .map(this::convertUserToUserResponseDTO)
        .collect(Collectors.toList());
    return responseDTOs;
  }

  @Override
  public void deleteUser(final UUID userId) {
    final UserEntity user = this.findUserById(userId);
    user.setDeletedAt(LocalDateTime.now());
    this.userRepository.save(user);
  }

  private UserEntity findUserById(final UUID userId) {
    final UserEntity user = this.userRepository.findActiveUserById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for ID: " + userId));
    return user;
  }

  private UserResponseDTO convertUserToUserResponseDTO(final UserEntity userEntity) {
    final UserResponseDTO userResponseDTO = new UserResponseDTO();
    userResponseDTO.setId(userEntity.getId());
    userResponseDTO.setName(userEntity.getName());
    userResponseDTO.setEmail(userEntity.getEmail());
    userResponseDTO.setPhoneNumber(userEntity.getPhoneNumber());
    userResponseDTO.setRole(userEntity.getRole());
    userResponseDTO.setAddress(userEntity.getAddress());
    userResponseDTO.setCreatedAt(userEntity.getCreatedAt());
    userResponseDTO.setUpdatedAt(userEntity.getUpdatedAt());
    userResponseDTO.setDeletedAt(userEntity.getDeletedAt());
    return userResponseDTO;
  }

}
