package com.controller;

import com.dto.KorpaVozilaDTO;
import com.model.KorpaVozila;
import com.service.KorpaVozilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/korpa", produces = MediaType.APPLICATION_JSON_VALUE)
public class KorpaVozilaKontroler {

    @Autowired
    private KorpaVozilaService korpaVozilaService;

    @PostMapping("/addVehicleToCart")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public ResponseEntity add(@Valid @RequestBody KorpaVozilaDTO vozilo) {
        korpaVozilaService.addVehicleToCart(vozilo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allVozila")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public List<KorpaVozila> findAll() throws AccessDeniedException {
        return this.korpaVozilaService.findAll();
    }

    @PostMapping("/rentACarRequest")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public ResponseEntity rentACarRequest(@Valid @RequestBody KorpaVozilaDTO vozilo) {
        korpaVozilaService.rentACarRequest(vozilo);
        return ResponseEntity.ok().build();
    }
}
