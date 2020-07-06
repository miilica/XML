package com.controller;

import com.dto.VrstaGorivaDTO;
import com.model.TipGoriva;
import com.service.impl.VrstaGorivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tipgoriva", produces = MediaType.APPLICATION_JSON_VALUE)
public class VrstaGorivaController {

    @Autowired
    private VrstaGorivaService vrstaGorivaService;


    @PostMapping("/dodaj")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity add(@RequestBody VrstaGorivaDTO mDTO) {
        vrstaGorivaService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TipGoriva> loadAll() {
        return this.vrstaGorivaService.findAll();
    }

    @PutMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TipGoriva> edit(@RequestBody VrstaGorivaDTO vrstaGorivaDTO){
        return new ResponseEntity<>(this.vrstaGorivaService.edit(vrstaGorivaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        vrstaGorivaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
