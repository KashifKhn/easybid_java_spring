package com.easybid.Users;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.easybid.Users.dto.CreateUserDTO;
import com.easybid.Users.dto.UpdateUserDTO;
import com.easybid.Users.dto.UserResponseDTO;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public ResponseEntity<UserResponseDTO> createUser(final CreateUserDTO createUserDTO) {
    UserEntity userEntity = new UserEntity();
    throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
  }

  @Override
  public ResponseEntity<UserResponseDTO> updateUser(final UUID userId, final UpdateUserDTO updateUserDTO) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
  }

  @Override
  public ResponseEntity<UserResponseDTO> getUserById(final UUID userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
  }

  @Override
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
  }

  @Override
  public ResponseEntity<UserResponseDTO> deleteUser(final UUID userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
  }

}
