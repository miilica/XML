package com.controller;

import com.dto.KlasaAutomobilaDTO;
import com.model.KlasaAutomobila;
import com.service.impl.KlasaAutomobilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/klasa", produces = MediaType.APPLICATION_JSON_VALUE)
public class KlasaAutomobilaController {

    @Autowired
    private KlasaAutomobilaService klasaAutomobilaService;


    @PostMapping("/dodaj")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity add(@RequestBody KlasaAutomobilaDTO mDTO) {
        klasaAutomobilaService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<KlasaAutomobila> loadAll() {
        return this.klasaAutomobilaService.findAll();
    }
}
