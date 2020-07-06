package com.controller;

import com.dto.OglasDTO;
import com.model.Oglas;
import com.service.OglasService;
import com.service.impl.OglasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/oglasi", produces = MediaType.APPLICATION_JSON_VALUE)
public class OglasController {

    @Autowired
    private OglasService oglasService;

    @Autowired
    private OglasServiceImpl oglasServiceImpl;

    @GetMapping("/allAds")
   // @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public List<Oglas> findAll() throws AccessDeniedException {
        return this.oglasService.findAll();
    }

    @PutMapping("/edit")
    public ResponseEntity<Oglas> edit(@RequestBody OglasDTO oglasDTO){
        return new ResponseEntity<>(this.oglasServiceImpl.edit(oglasDTO), HttpStatus.OK);
    }

    @PostMapping("/dodaj")
    public ResponseEntity<?> addNew(@RequestBody OglasDTO oglasDTO) {
        return this.oglasService.noviOglas(oglasDTO);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        oglasServiceImpl.delete(id);
        return ResponseEntity.ok().build();
    }
}
