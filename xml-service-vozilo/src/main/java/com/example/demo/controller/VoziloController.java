package com.example.demo.controller;


import com.example.demo.dto.VoziloDTO;
import com.example.demo.model.Vozilo;
import com.example.demo.service.VoziloServiceImpl;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/vozilo")
public class VoziloController {

    @Autowired
    private VoziloServiceImpl voziloService;

    @PostMapping("/dodaj")
    public ResponseEntity add(@RequestBody VoziloDTO mDTO) throws Base64DecodingException, SQLException, AccessDeniedException {
        voziloService.dodajNovoVozilo(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    public List<Vozilo> loadAll() {
        return this.voziloService.findAll();
    }

    @GetMapping("/allVozila")
    public List<Vozilo> findAll() throws AccessDeniedException {
        return this.voziloService.findAll();
    }

   /* @GetMapping("/user/agent/allTermineIznajmljivanja")
    public List<TerminIznajmljivanja> loadAllTermineIznajmljivanja() {
        return this.voziloService.findAllTermineIznajmljivanja();
    }*/

    @PutMapping(value = "/user/agent/dodajKM/{dodatiKM}")
    public ResponseEntity addKm (@Valid @RequestBody VoziloDTO voziloDTO, @PathVariable Double dodatiKM) {
        voziloService.addKmToVehicle(voziloDTO, dodatiKM);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allVozila/kaca")
    public ResponseEntity<?> findAllVozila() throws AccessDeniedException {
        return this.voziloService.findAllVozila();
    }

    @GetMapping(value = "getVozilaAgent")
    public ResponseEntity<?> getAllVozilaAgent(){
        return this.voziloService.getAllVozilaAgent();
    }

}
