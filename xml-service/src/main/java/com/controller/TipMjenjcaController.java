package com.controller;

import com.dto.TipMjenjacaDTO;
import com.model.TipMjenjaca;
import com.service.impl.TipMjenjacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tipmjenjaca", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipMjenjcaController {
    @Autowired
    private TipMjenjacaService tipMjenjacaService;


    @PostMapping("/dodaj")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity add(@RequestBody TipMjenjacaDTO mDTO) {
        tipMjenjacaService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TipMjenjaca> loadAll() {
        return this.tipMjenjacaService.findAll();
    }

    @PutMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TipMjenjaca> edit(@RequestBody TipMjenjacaDTO tipMjenjacaDTO){
        return new ResponseEntity<>(this.tipMjenjacaService.edit(tipMjenjacaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@RequestBody TipMjenjacaDTO tipMjenjacaDTO){
        return new ResponseEntity<>(this.tipMjenjacaService.delete(tipMjenjacaDTO),HttpStatus.OK);
    }
}
