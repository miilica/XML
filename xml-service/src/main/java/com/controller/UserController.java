package com.controller;

import com.dto.UserRegistrationDTO;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

    @PostMapping("/public/register")
    public ResponseEntity add(@Valid @RequestBody UserRegistrationDTO user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
	// Ukoliko nema, server ce vratiti gresku 403 Forbidden
	// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
	@GetMapping("/user/{userId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@GetMapping("/user/all")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> loadAll() {
		return this.userService.findAll();
	}

	@GetMapping("/user/allKorisnike")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> loadAllKorisnike() {
		return this.userService.findAllKorisnike();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("activate/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity activate(@PathVariable Long id) {
		userService.activateUser(id);
		return ResponseEntity.ok().build();
	}



}
