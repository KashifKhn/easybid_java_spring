package com.easybid.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//@Component
@Service
public class PasswordHasher {

  private final BCryptPasswordEncoder passwordEncoder;

  public PasswordHasher(final BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.passwordEncoder = bCryptPasswordEncoder;
  }

  public String hash(final String plainPassword) {
    return passwordEncoder.encode(plainPassword);
  }

  public boolean matches(final String plainPassword, final String hashedPassword) {
    return passwordEncoder.matches(plainPassword, hashedPassword);
  }
}
