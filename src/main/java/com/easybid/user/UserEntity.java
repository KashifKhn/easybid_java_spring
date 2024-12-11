package com.easybid.user;

import com.easybid.user.dto.UpdateUserDTO;

import java.util.Set;

import com.easybid.auth.PasswordHasher;
import com.easybid.common.BaseEntity;
import com.easybid.enums.UsersRole;
import com.easybid.item.ItemEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Schema()
@Table(name = "users")
public class UserEntity extends BaseEntity {

  @Column(nullable = false, length = 255)
  private String name;

  @Column(nullable = false, length = 255, unique = true)
  @Email
  private String email;

  @Column(nullable = false, length = 255)
  private String hashPassword;

  @Column(nullable = false, length = 255)
  private String address;

  @Column(nullable = true, length = 255)
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UsersRole role;

  @OneToMany(mappedBy = "user")
  private Set<ItemEntity> items;

  public void updateFromDTO(UpdateUserDTO dto, PasswordHasher passwordHasher) {
    if (dto.getName() != null && !dto.getName().isBlank()) {
      this.setName(dto.getName());
    }
    if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
      this.setEmail(dto.getEmail());
    }
    if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
      this.setHashPassword(passwordHasher.hash(dto.getPassword()));
    }
    if (dto.getAddress() != null && !dto.getAddress().isBlank()) {
      this.setAddress(dto.getAddress());
    }
    if (dto.getPhoneNumber() != null && !dto.getPhoneNumber().isBlank()) {
      this.setPhoneNumber(dto.getPhoneNumber());
    }
    if (dto.getRole() != null) {
      this.setRole(dto.getRole());
    }
  }

}
