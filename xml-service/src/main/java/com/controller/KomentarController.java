package com.controller;

import com.dto.KomentarDTO;
import com.service.impl.KomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/komentar", produces = MediaType.APPLICATION_JSON_VALUE)
public class KomentarController {
    private KomentarService komentarService;

    @Autowired
    public KomentarController(KomentarService komentarService) {
        this.komentarService = komentarService;
    }

    @PostMapping(value = "/dodaj")
    private ResponseEntity<?> dodajKomentar(@RequestBody KomentarDTO komentarDTO){
        return this.komentarService.kreirajKomentar(komentarDTO);
    }

    @GetMapping(value = "/getKomentareVozilo/{voziloId}")
    private ResponseEntity<?> pokupiKomentare(@PathVariable Long voziloId){
        return this.komentarService.pokupiKomentare(voziloId);
    }
}
