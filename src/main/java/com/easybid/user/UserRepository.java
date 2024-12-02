package com.easybid.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findByEmail(String email);

  @Query("SELECT u FROM UserEntity u WHERE u.deletedAt IS NULL")
  List<UserEntity> findAllActiveUsers();

  @Query("SELECT u FROM UserEntity u WHERE u.id = :userId AND u.deletedAt IS NULL")
  Optional<UserEntity> findActiveUserById(UUID userId);

}
