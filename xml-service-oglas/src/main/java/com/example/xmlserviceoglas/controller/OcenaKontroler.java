package com.example.xmlserviceoglas.controller;

import com.example.xmlserviceoglas.dto.OcenaDTO;
import com.example.xmlserviceoglas.services.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/ocena")
public class OcenaKontroler {

    private OcenaService ocenaService;

    @Autowired
    public OcenaKontroler(OcenaService ocenaService) {
        this.ocenaService = ocenaService;
    }

    @PostMapping()
    private ResponseEntity<?> kreirajOcjenu(@RequestBody OcenaDTO ocenaDTO){
       return this.ocenaService.kreirajOcjenu(ocenaDTO);
    }

    @GetMapping(value = "/vozilo/{voziloId}")
    private ResponseEntity<?> getOcjeneZaAuto(@PathVariable Long voziloId){
        return this.ocenaService.getOcjeneZaAuto(voziloId);
    }
}
