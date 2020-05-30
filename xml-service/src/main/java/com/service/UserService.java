package com.service;

import com.dto.UserRegistrationDTO;
import com.model.User;
import com.model.UserRequest;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
	User save(UserRequest userRequest);
    User addUser(UserRegistrationDTO userInfo);
}
