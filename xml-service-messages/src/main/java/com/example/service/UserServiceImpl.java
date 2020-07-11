package com.example.service;


import com.example.dto.UserDTO;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	private PasswordEncoder passwordEncoder;


	private ModelMapper modelMapper;

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		return u;
	}

	public User getLoogedIn() throws AccessDeniedException {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String username;
//		if (principal instanceof UserDetails) {
//			 username = ((UserDetails)principal).getUsername();
//		} else {
//			 username = principal.toString();
//		}
//		System.out.println(username+"userko");
//
//		return  findByUsername(username);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object currentUser = auth.getPrincipal();

		String username = "";
		if(currentUser instanceof UserDetails){
			username = ((UserDetails)currentUser).getUsername();
		}else{
			username = currentUser.toString();
		}
		System.out.println(username);
		User u = userRepository.findByUsername(username);
		return u;
	}



	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).orElseGet(null);
		return u;
	}

	public List<UserDTO> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		List<UserDTO> userDTOS = new ArrayList<>();

		for(User u: result){
			userDTOS.add(modelMapper.map(u, UserDTO.class));
		}

		return userDTOS;
	}

	public List<UserDTO> findAllKorisnike() throws AccessDeniedException {
		List<User> allUsers = userRepository.findAll();
		List<UserDTO> result = new ArrayList<>();
		for(User u : allUsers) {
			if(!u.isAdmin()) {
				result.add(modelMapper.map(u, UserDTO.class));
			}
		}
		return result;
	}








}
