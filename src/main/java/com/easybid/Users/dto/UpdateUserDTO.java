package com.easybid.Users.dto;

import com.easybid.enums.UsersRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for updating an existing user")
public class UpdateUserDTO {

  @Schema(description = "Updated name of the user", example = "John Doe")
  private String name;

  @Email
  @Schema(description = "Updated email of the user", example = "john.doe@example.com")
  private String email;

  @Schema(description = "Updated password of the user", example = "newSecurePassword123")
  private String password;

  @Schema(description = "Updated address of the user", example = "456 Elm St, Newtown, USA")
  private String address;

  @Schema(description = "Updated phone number of the user", example = "+9876543210")
  private String phoneNumber;

  @Schema(description = "Updated role of the user", example = "ADMIN")
  private UsersRole role;
}
