package com.example.service;

import com.example.dto.UserDTO;
import com.example.dto.UserRegistrationDTO;
import com.example.model.User;
import com.example.model.UserRequest;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<UserDTO> findAll();
    List<UserDTO> findAllKorisnike();
    User save(UserRequest userRequest);
    User addUser(UserRegistrationDTO userInfo);
    void delete(Long id);
    void activateUser(Long id);
    public User getLoogedIn();
}
