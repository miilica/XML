package com.example.demo.controller;

import com.example.demo.dto.MarkaAutomobilaDTO;
import com.example.demo.model.MarkaAutomobila;
import com.example.demo.service.MarkaAutomobilaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/marka")
public class MarkaAutomobilaController {

    @Autowired
    private MarkaAutomobilaService markaAutomobilaService;


    @PostMapping("/dodaj")
    public ResponseEntity add(@RequestBody MarkaAutomobilaDTO mDTO) {
        markaAutomobilaService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    public List<MarkaAutomobilaDTO> loadAll() throws AccessDeniedException {
        return this.markaAutomobilaService.findAll();
    }


    @GetMapping()
    public ResponseEntity<?> getAll() {
        return this.markaAutomobilaService.getAll();
    }
    
    @PutMapping("/edit")
    public ResponseEntity<MarkaAutomobila> edit(@RequestBody MarkaAutomobilaDTO markaAutomobilaDTO) throws AccessDeniedException {
        return new ResponseEntity<>(this.markaAutomobilaService.edit(markaAutomobilaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws AccessDeniedException {
        markaAutomobilaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/models/{markId}")
    public ResponseEntity<?> getAllModels(@PathVariable Long markId) {
        return this.markaAutomobilaService.getAllModels(markId);
    }
}
