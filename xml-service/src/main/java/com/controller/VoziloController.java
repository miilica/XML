package com.controller;

import com.dto.KorpaVozilaDTO;
import com.dto.VoziloDTO;
import com.model.Vozilo;
import com.service.KorpaVozilaService;
import com.service.VoziloService;
import com.service.impl.KorpaVozilaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/vozilo", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoziloController {

    @Autowired
    private VoziloService voziloService;

    @GetMapping("/allVozila")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public List<Vozilo> findAll() throws AccessDeniedException {
        return this.voziloService.findAll();
    }

}
