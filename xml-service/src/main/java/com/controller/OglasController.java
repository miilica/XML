package com.controller;

import com.dto.PretragaDTO;
import com.dto.OglasDTO;
import com.model.Oglas;
import com.service.OglasService;
import com.service.impl.OglasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/oglasi")
public class OglasController {

    @Autowired
    private OglasServiceImpl oglasService;

   /* @GetMapping("/allAds")
   // @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public List<Oglas> findAll() throws AccessDeniedException {
        return this.oglasService.findAll();
    }*/

    @GetMapping( value = "/mjesta")
    public ResponseEntity<?> pretraziMjesta() {
        return this.oglasService.pretraziMjesta();
    }

    @PostMapping(value = "/pretraga/{page}/{sort}")
    public ResponseEntity<?> pretraziOglase(@RequestBody PretragaDTO pretraga, @PathVariable int page, @PathVariable String sort) {
        return this.oglasService.pretraziOglase(pretraga,page, sort);
    }

    @PostMapping("/dodaj")
    public ResponseEntity<?> addNew(@RequestBody OglasDTO oglasDTO) {

        return this.oglasService.noviOglas(oglasDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOneOglasById(@PathVariable Long id) {
        return this.oglasService.getOneOglasById(id);
    }
}
