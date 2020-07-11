package com.example.demo.controller;


import com.example.demo.dto.TipMjenjacaDTO;
import com.example.demo.model.TipMjenjaca;
import com.example.demo.service.TipMjenjacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tipmjenjaca", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipMjenjcaController {
    @Autowired
    private TipMjenjacaService tipMjenjacaService;


    @PostMapping("/dodaj")
    public ResponseEntity add(@RequestBody TipMjenjacaDTO mDTO) {
        tipMjenjacaService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    public List<TipMjenjacaDTO> loadAll() throws AccessDeniedException {
        return this.tipMjenjacaService.findAll();
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return this.tipMjenjacaService.getAll();
    }

    @PutMapping("/edit")
    public ResponseEntity<TipMjenjaca> edit(@RequestBody TipMjenjacaDTO tipMjenjacaDTO) throws AccessDeniedException {
        return new ResponseEntity<>(this.tipMjenjacaService.edit(tipMjenjacaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws AccessDeniedException {
        tipMjenjacaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
