package com.controller;

import com.dto.TerminIznajmljivanjaDTO;
import com.service.impl.TerminIznajmljivanjaServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/terminIznajmljivanja", produces = MediaType.APPLICATION_JSON_VALUE)
public class TerminIznajmljivanjaKontroler {

    @Autowired
    private TerminIznajmljivanjaServis terminIznajmljivanjaServis;

    @PostMapping
    public ResponseEntity<?> dodaj(@RequestBody TerminIznajmljivanjaDTO terminIznajmljivanjaDTO) {
        return this.terminIznajmljivanjaServis.newTerminIznajmljivanja(terminIznajmljivanjaDTO);
    }
}
