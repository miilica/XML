package com.controller;

import com.dto.VrstaGorivaDTO;
import com.service.impl.VrstaGorivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
