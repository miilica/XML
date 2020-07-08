package com.controller;

import com.dto.MarkaAutomobilaDTO;
import com.model.MarkaAutomobila;
import com.service.impl.MarkaAutomobilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/marka", produces = MediaType.APPLICATION_JSON_VALUE)
public class MarkaAutomobilaController {

    @Autowired
    private MarkaAutomobilaService markaAutomobilaService;


    @PostMapping("/dodaj")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity add(@RequestBody MarkaAutomobilaDTO mDTO) {
        markaAutomobilaService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<MarkaAutomobila> loadAll() {
        return this.markaAutomobilaService.findAll();
    }

    // Katarina radila(ne brisati)
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return this.markaAutomobilaService.getAll();
    }

    // Katarina radila(ne brisati)
    @GetMapping(value = "/models/{markId}")
    public ResponseEntity<?> getAllModels(@PathVariable Long markId) {
        return this.markaAutomobilaService.getAllModels(markId);
    }
}
