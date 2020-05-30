package com.mappers;


import com.dto.UserDTO;
import com.dto.UserRegistrationDTO;
import com.model.Korisnik;
import com.model.User;

public class UserMapper {

    public static User toUserEntity(UserRegistrationDTO userInfo) {
        User user = new User();
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setEmail(userInfo.getName());

        return user;
    }

    public static Korisnik toKorisnikEntity(UserRegistrationDTO userInfo) {
        Korisnik user = new Korisnik();
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setName(userInfo.getName());

        return user;
    }

    public static UserDTO toDto(User user) {
        return new UserDTO(user);
    }

    private UserMapper() {
    }
}
