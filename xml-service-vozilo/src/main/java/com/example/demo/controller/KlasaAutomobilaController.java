package com.example.demo.controller;


import com.example.demo.dto.KlasaAutomobilaDTO;
import com.example.demo.model.KlasaAutomobila;
import com.example.demo.service.KlasaAutomobilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/klasa")
public class KlasaAutomobilaController {

    @Autowired
    private KlasaAutomobilaService klasaAutomobilaService;


    @PostMapping("/dodaj")
    public ResponseEntity add(@RequestBody KlasaAutomobilaDTO mDTO) {
        klasaAutomobilaService.save(mDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public List<KlasaAutomobilaDTO> loadAll() throws AccessDeniedException {
        return this.klasaAutomobilaService.findAll();
    }

    // Katarina radila(ne brisati)
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return this.klasaAutomobilaService.getAll();
    }


    @PutMapping("/edit")
    public ResponseEntity<KlasaAutomobila> edit(@RequestBody KlasaAutomobilaDTO klasaAutomobilaDTO) throws AccessDeniedException {
        return new ResponseEntity<>(this.klasaAutomobilaService.edit(klasaAutomobilaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws AccessDeniedException {
        klasaAutomobilaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
