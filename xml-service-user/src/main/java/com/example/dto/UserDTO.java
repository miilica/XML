package com.example.dto;

import com.example.model.Authority;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.util.List;


@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String ucidn;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String password;
    private  String role;
    private boolean isAdmin;
    private Timestamp lastPasswordResetDate;
    private List<Authority> authorities;

    public UserDTO(Long id, String name, String surname, String username, String ucidn, String address, String city, String country, String email, String phone, String password, String role, boolean isAdmin, Timestamp lastPasswordResetDate, List<Authority> authorities) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.ucidn = ucidn;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.isAdmin = isAdmin;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
    }
}
