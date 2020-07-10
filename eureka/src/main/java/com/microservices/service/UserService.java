package com.microservices.service;


import com.microservices.dto.UserDTO;
import com.microservices.dto.UserRegistrationDTO;
import com.microservices.model.User;
import com.microservices.model.UserRequest;

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
