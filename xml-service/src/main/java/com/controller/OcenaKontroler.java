package com.controller;

import com.dto.OcenaDTO;
import com.service.OcenaService;
import com.service.impl.OcenaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/ocena")
public class OcenaKontroler {

    private OcenaServiceImpl ocenaService;

    @Autowired
    public OcenaKontroler(OcenaServiceImpl ocenaService) {
        this.ocenaService = ocenaService;
    }

    @PostMapping()
    private ResponseEntity<?> kreijarOcjenu(@RequestBody OcenaDTO ocenaDTO){
       return this.ocenaService.kreirajOcjenu(ocenaDTO);
    }

    @GetMapping(value = "/vozilo/{voziloId}")
    private ResponseEntity<?> getOcjeneZaAuto(@PathVariable Long voziloId){
        return this.ocenaService.getOcjeneZaAuto(voziloId);
    }
}
