package com.controller;

import com.dto.KomentarDTO;
import com.service.impl.KomentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/komentar")
public class KomentarController {

    @Autowired
    private KomentarService komentarService;

    @PostMapping(value = "/dodaj/{username}")
    private ResponseEntity<?> dodajKomentar(@RequestBody KomentarDTO komentarDTO, @PathVariable String username){
        return this.komentarService.kreirajKomentar(komentarDTO, username);
    }

    @GetMapping(value = "/getKomentareVozilo/{voziloId}")
    private ResponseEntity<?> pokupiKomentare(@PathVariable Long voziloId){
        return this.komentarService.pokupiKomentare(voziloId);
    }

    @GetMapping()
    private ResponseEntity<?> pokupiKomentareSve(){
        return this.komentarService.pokupiSveKomentare();
    }

    @GetMapping(value = "/odobri/{flag}/{id}")
    private ResponseEntity<?> odobriKomentar(@PathVariable Boolean flag, @PathVariable Long id){
        return this.komentarService.odobriKomentar(flag, id);
    }
}
