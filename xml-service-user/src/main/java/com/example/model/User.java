package com.example.model;

import java.security.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
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


    public User() {
    }

    public User(String name, String surname, String ucidn, String address, String city, String country, String email,
                String phone, String password, String role, List<Authority> authorities, String username) {
        this.name = name;
        this.surname = surname;
        this.ucidn = ucidn;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
        this.username = username;
    }
}
