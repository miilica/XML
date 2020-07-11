package com.example.xmlserviceoglas.controller;

import com.example.xmlserviceoglas.dto.KorpaVozilaDTO;
import com.example.xmlserviceoglas.model.KorpaVozila;
import com.example.xmlserviceoglas.services.KorpaVozilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/korpa")
public class KorpaVozilaKontroler {

    @Autowired
    private KorpaVozilaService korpaVozilaService;

    @PostMapping("/addVehicleToCart")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public ResponseEntity add(@RequestBody KorpaVozilaDTO vozilo) {
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
    public ResponseEntity rentACarRequest(@RequestBody KorpaVozilaDTO vozilo) {
        korpaVozilaService.rentACarRequest(vozilo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rentACarRequestBundle")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public ResponseEntity rentACarRequestBundle(@RequestBody KorpaVozilaDTO[] listaVozila) {
        korpaVozilaService.rentACarRequestBundle(listaVozila);
        return ResponseEntity.ok().build();
    }
}
