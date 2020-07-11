package com.example.demo.controller;


import com.example.demo.dto.VrstaGorivaDTO;
import com.example.demo.model.TipGoriva;
import com.example.demo.service.VrstaGorivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tipgoriva")
public class VrstaGorivaController {

    @Autowired
    private VrstaGorivaService vrstaGorivaService;


    @PostMapping("/dodaj")
    public ResponseEntity add(@RequestBody VrstaGorivaDTO mDTO) {
        vrstaGorivaService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    public List<VrstaGorivaDTO> loadAll() throws AccessDeniedException {
        return this.vrstaGorivaService.findAll();
    }

    // Katarina radila(ne brisati)
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return this.vrstaGorivaService.getAll();
    }

    @PutMapping("/edit")
    public ResponseEntity<TipGoriva> edit(@RequestBody VrstaGorivaDTO vrstaGorivaDTO) throws AccessDeniedException {
        return new ResponseEntity<>(this.vrstaGorivaService.edit(vrstaGorivaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws AccessDeniedException {
        vrstaGorivaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
