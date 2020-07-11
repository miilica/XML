package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationDTO {

    @NotNull(message = "Username must be provided")
    private String username;

    @NotNull(message = "Email must be provided")
    @Email(regexp = ".+@.+\\..+", message = "Email is not valid")
    private String email;

    @NotNull(message = "Password must be provided")
    private String password;

    @NotNull(message = "Password repeat must be provided")
    private String repeatPassword;

    @NotNull(message = "Name must be provided")
    private String name;

    @NotNull(message = "Surname must be provided")
    private String surname;

    @NotNull(message = "Address must be provided")
    private String address;

    @NotNull(message = "City must be provided")
    private String city;

    @NotNull(message = "Country must be provided")
    private String country;

    @NotNull(message = "Phone must be provided")
    private String phone;

}
