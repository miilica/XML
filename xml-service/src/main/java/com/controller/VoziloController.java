package com.controller;

import com.dto.VoziloDTO;
import com.model.Vozilo;
import com.service.impl.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vozilo", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoziloController {
    @Autowired
    private VoziloService voziloService;


    @PostMapping("/dodaj")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity add(@RequestBody VoziloDTO mDTO) {
        voziloService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Vozilo> loadAll() {
        return this.voziloService.findAll();
    }
}
