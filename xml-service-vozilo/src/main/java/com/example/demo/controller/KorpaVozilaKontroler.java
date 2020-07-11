package com.example.demo.controller;

import com.example.demo.dto.KorpaVozilaDTO;
import com.example.demo.model.KorpaVozila;
import com.example.demo.service.KorpaVozilaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/korpa")
public class KorpaVozilaKontroler {

    @Autowired
    private KorpaVozilaServiceImpl korpaVozilaService;

    @PostMapping("/addVehicleToCart")
    public ResponseEntity add(@Valid @RequestBody KorpaVozilaDTO vozilo) {
        korpaVozilaService.addVehicleToCart(vozilo);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allVozila")
    public List<KorpaVozila> findAll() throws AccessDeniedException {
        return this.korpaVozilaService.findAll();
    }

    @PostMapping("/rentACarRequest")
    public ResponseEntity rentACarRequest(@Valid @RequestBody KorpaVozilaDTO vozilo) throws AccessDeniedException {
        korpaVozilaService.rentACarRequest(vozilo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rentACarRequestBundle")
    public ResponseEntity rentACarRequestBundle(@RequestBody KorpaVozilaDTO[] listaVozila) {
        korpaVozilaService.rentACarRequestBundle(listaVozila);
        return ResponseEntity.ok().build();
    }
}
