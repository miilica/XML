package com.controller;

import com.dto.PorukaDTO;
import com.service.PorukaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/poruke" , produces = MediaType.APPLICATION_JSON_VALUE)
public class PorukaController {

    @Autowired
    private PorukaService porukaService;

    @GetMapping(value = "/{posiljalacId}/{primalacId}/{oglasId}")
    //@PreAuthorize("hasRole('ROLE_AGENT') || hasRole('ROLE_KORISNIK')")
    public List<PorukaDTO>get(@PathVariable("posiljalacId") Long posiljalacId, @PathVariable("primalacId") Long primalacId, @PathVariable("oglasId") Long oglasId){
        return porukaService.get(posiljalacId,primalacId,oglasId);
    }

    @GetMapping(value = "/{Id}")
    //@PreAuthorize("hasRole('ROLE_AGENT') || hasRole('ROLE_KORISNIK')")
    public List<PorukaDTO>getMojePoruke(@PathVariable("Id") Long Id){
        return porukaService.getMojePoruke(Id);
    }


    @PostMapping
    //@PreAuthorize("hasRole('ROLE_AGENT') || hasRole('ROLE_KORISNIK')")
    public void posaljiPoruku(@RequestBody PorukaDTO porukaDTO){
        porukaService.posaljiPoruku(porukaDTO);
    }

}
