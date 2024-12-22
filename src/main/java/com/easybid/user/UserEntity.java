package com.easybid.user;

import java.util.List;

import com.easybid.common.BaseEntity;
import com.easybid.enums.UsersRole;
import com.easybid.item.ItemEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
  @JsonManagedReference("user-item")
  private List<ItemEntity> items;

}
