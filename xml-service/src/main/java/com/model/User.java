package com.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Inheritance;
import java.util.Collection;
import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

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
<<<<<<< Updated upstream
=======

    @Column
    private boolean isAdmin;



  
    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;
>>>>>>> Stashed changes

    public User() {
    }

    public User(String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String password, String role) {
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
    }
}
