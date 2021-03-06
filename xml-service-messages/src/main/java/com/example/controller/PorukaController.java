package com.example.controller;

import com.example.dto.PorukaDTO;
import com.example.service.PorukaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/poruke")
public class PorukaController {

    @Autowired
    private PorukaService porukaService;

    @GetMapping(value = "/{posiljalacId}/{primalacId}/{oglasId}")
   // @PreAuthorize("hasRole('ROLE_AGENT') || hasRole('ROLE_KORISNIK')")
    public List<PorukaDTO> get(@PathVariable("posiljalacId") Long posiljalacId, @PathVariable("primalacId") Long primalacId, @PathVariable("oglasId") Long oglasId) {
        return porukaService.get(posiljalacId, primalacId, oglasId);
    }

    @GetMapping(value = "/{Id}")
    //@PreAuthorize("hasRole('ROLE_AGENT') || hasRole('ROLE_KORISNIK')")
    public List<PorukaDTO>getMojePoruke(@PathVariable("Id") Long Id){
        return porukaService.getMojePoruke(Id);
    }


    @PostMapping
    //@PreAuthorize("hasRole('ROLE_AGENT') || hasRole('ROLE_KORISNIK')")
    public void posaljiPoruku(@RequestBody PorukaDTO porukaDTO) {
        porukaService.posaljiPoruku(porukaDTO);
    }
}
