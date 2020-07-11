package com.service;

import com.dto.KomentarDTO;
import com.dto.UserDTO;
import com.dto.UserRegistrationDTO;
import com.model.User;
import com.model.UserRequest;
import javassist.NotFoundException;

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
    void activateComment(Long id);
    public User getLoogedIn();
    List<KomentarDTO> loadAllComments();
   // boolean verify(String email) throws NotFoundException;
}
