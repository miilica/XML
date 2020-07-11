package com.example.xmlserviceoglas.controller;

import com.example.xmlserviceoglas.dto.OglasDTO;
import com.example.xmlserviceoglas.model.Oglas;
import com.example.xmlserviceoglas.services.OglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/oglasi")
public class OglasController {

    @Autowired
    private OglasService oglasService;

    @GetMapping("/allAds")
    public List<Oglas> findAll() throws AccessDeniedException {
        return this.oglasService.findAll();
    }

    @PostMapping("/dodaj")
    public ResponseEntity<?> addNew(@RequestBody OglasDTO oglasDTO) {
        return this.oglasService.noviOglas(oglasDTO);
    }
}
