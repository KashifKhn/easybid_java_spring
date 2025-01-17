package com.easybid.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findByEmailAndDeletedAtIsNull(String email);

  List<UserEntity> findByDeletedAtIsNull();

  Optional<UserEntity> findByIdAndDeletedAtIsNull(UUID userId);

}
