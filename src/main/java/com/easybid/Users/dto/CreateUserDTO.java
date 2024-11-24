package com.easybid.Users.dto;

import com.easybid.enums.UsersRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for creating a new user")
public class CreateUserDTO {

  @NotBlank
  @Schema(description = "Name of the user", example = "John Doe")
  private String name;

  @NotBlank
  @Email
  @Schema(description = "Email of the user", example = "john.doe@example.com")
  private String email;

  @NotBlank
  @Schema(description = "Password of the user", example = "securePassword123")
  private String password;

  @NotBlank
  @Schema(description = "Address of the user", example = "123 Main St, Anytown, USA")
  private String address;

  @Schema(description = "Phone number of the user", example = "+1234567890")
  private String phoneNumber;

  @NotNull
  @Schema(description = "Role of the user", example = "USER")
  private UsersRole role;
}
