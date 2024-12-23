package com.easybid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages = "com.easybid")
public class EasybidApplication {

  public static void main(String[] args) {
    SpringApplication.run(EasybidApplication.class, args);
  }

}
