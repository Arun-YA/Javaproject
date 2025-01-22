package com.geppetto.Javaproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Builder;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "id cannot be null or empty")
    private String id;
     
    @NotBlank(message = "username cannot be null or empty")  
    private String username;
   
    @NotBlank(message = "email cannot be null or empty")  
    private String email;
   
    @NotBlank(message = "password cannot be null or empty")  
    private String password;
  
    }
