package com.example.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

// POJO koji implementira Spring Security GrantedAuthority kojim se mogu definisati role u aplikaciji

public class Authority{

    private static final long serialVersionUID = 1L;


    Long id;


    String name;

    //@Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // @JsonIgnore
    public String getName() {
        return name;
    }

   // @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}