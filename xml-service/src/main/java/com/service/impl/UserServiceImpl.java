package com.service.impl;

import com.common.TimeProvider;
import com.config.consts.UserRoles;
import com.dto.UserRegistrationDTO;
import com.exception.ApiRequestException;
import com.mappers.UserMapper;
import com.model.*;
import com.repository.AuthorityRepository;
import com.repository.ConfirmationTokenRepository;
import com.repository.UserRepository;
import com.service.AuthorityService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;

	@Autowired
	private ConfirmationTokenRepository tokenRepository;

	@Autowired
	private TimeProvider timeProvider;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		return u;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).orElseGet(null);
		return u;
	}

	public List<User> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		return result;
	}

	@Override
	public User save(UserRequest userRequest) {
		User u = new User();
		// pre nego sto postavimo lozinku u atribut hesiramo je
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		u.setName(userRequest.getFirstname());
		u.setSurname(userRequest.getLastname());
		
		List<Authority> auth = authService.findByname("ROLE_USER");
		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		u.setAuthorities(auth);
		
		u = this.userRepository.save(u);
		return u;
	}

	@Override
	public User addUser(UserRegistrationDTO userInfo) {
		if (userRepository.findByUsername(userInfo.getUsername()) != null) {
			throw new ApiRequestException("Username '" + userInfo.getUsername() + "' already exists.");
		}

		if (!userInfo.getPassword().equals(userInfo.getRepeatPassword())) {
			throw new ApiRequestException("Provided passwords must be the same.");
		}

		if (userRepository.findByEmail(userInfo.getEmail()) != null) {
			throw new ApiRequestException("Email '" + userInfo.getEmail() + "' is taken.");
		}

		User user = createNewUserObject(userInfo);
		userRepository.save(user);

		ConfirmationToken token = new ConfirmationToken(user);
		tokenRepository.save(token);

		//mailSenderService.sendRegistrationMail(token);

		return user;
	}

	private User createNewUserObject(UserRegistrationDTO userInfo) {
		//Korisnik user = UserMapper.toKorisnikEntity(userInfo);
		User user = UserMapper.toUserEntity(userInfo);
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		user.setLastPasswordResetDate(timeProvider.nowTimestamp());
		user.getUserAuthorities().add(authorityRepository.findByName(UserRoles.ROLE_BUYER));

		//aktivacija naloga
		user.setEnabled(true);
		return user;
	}

}
