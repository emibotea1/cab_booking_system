package com.emanuel.cab.dto;

import com.emanuel.cab.model.Role;
import com.emanuel.cab.util.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String phoneNumber;
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    private Role role;
}