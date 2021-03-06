package com.controller;

import com.dto.KomentarDTO;
import com.dto.UserDTO;
import com.dto.UserRegistrationDTO;
import com.model.Komentar;
import com.model.User;
import com.model.Zahtjev;
import com.repository.KomentarRepository;
import com.service.UserService;
import com.service.ZahtjevService;
import com.service.impl.KomentarService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ZahtjevService zahtjevService;

	@Autowired
	private KomentarRepository komentarRepository;

    @PostMapping("/public/register")
    public ResponseEntity add(@Valid @RequestBody UserRegistrationDTO user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
	// Ukoliko nema, server ce vratiti gresku 403 Forbidden
	// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
	@GetMapping("/user/{userId}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@GetMapping("/getLoggedIn")
	public User getLoggedIn() {
		return this.userService.getLoogedIn();
	}

	@GetMapping("/user/all")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<UserDTO> loadAll() {

    	return this.userService.findAll();
	}

	@GetMapping("/user/allKorisnike")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<UserDTO> loadAllKorisnike() {
		return this.userService.findAllKorisnike();
	}

	@GetMapping("/allComments")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<KomentarDTO> loadAllComments() {
		return this.userService.loadAllComments();
	}

	@GetMapping("activateComment/{id}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity activateComment(@PathVariable Long id) {
		userService.activateComment(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("activate/{id}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity activate(@PathVariable Long id) {
		userService.activateUser(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/payForRent")
	//@PreAuthorize("hasRole('ROLE_KORISNIK')")
	public ResponseEntity payForRent(@Valid @RequestBody Zahtjev zahtjev) {
		zahtjevService.payForRentACar(zahtjev);
		return ResponseEntity.ok().build();
	}

//	@GetMapping("/verify/{email}")
//	public ResponseEntity<?> verify(@PathVariable("email") String email) throws NotFoundException {
//		System.out.println("Verification invoked!");
//		return new ResponseEntity<>(this.userService.verify(email), HttpStatus.OK);
//	}

}
