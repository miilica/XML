package com.example.service;

import com.example.dto.UserDTO;
import com.example.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    User save(UserDTO userDTO);
    User delete(UserDTO userDTO);
}
