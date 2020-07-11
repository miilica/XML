package com.example.demo.dto;


import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String name;
    private String email;
    private String address;
    private boolean enabled;
    private List<String> authorities;
   // private UserTokenDTO token;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
        this.address = user.getAddress();
       // this.enabled = user.isEnabled();
        //this.token = null;

        //this.authorities = user.getAuthorities().stream()
             //   .map(authority -> ((Authority) authority).getName()).collect(Collectors.toList());
    }

}
