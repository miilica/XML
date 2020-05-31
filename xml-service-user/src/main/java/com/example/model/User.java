package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.security.Timestamp;
import java.util.List;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String username;

    @Column
    private String ucidn;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;


    @Column
    private  String role;

    @Column

    private boolean isAdmin;


    private Timestamp lastPasswordResetDate;


    //private List<Authority> authorities;


}
