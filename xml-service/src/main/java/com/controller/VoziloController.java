package com.controller;

import com.dto.VoziloDTO;
import com.model.TerminIznajmljivanja;
import com.dto.ZauzeceDTO;
import com.model.Vozilo;
import com.service.impl.VoziloServiceImpl;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/vozilo", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoziloController {

    @Autowired
    private VoziloServiceImpl voziloService;

    @PostMapping("/dodaj")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity add(@RequestBody VoziloDTO mDTO) throws Base64DecodingException, SQLException {
        voziloService.save(mDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Vozilo> loadAll() {
        return this.voziloService.findAll();
    }

    @GetMapping("/allVozila")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public List<Vozilo> findAll() throws AccessDeniedException {
        return this.voziloService.findAll();
    }

    @GetMapping("/user/agent/allTermineIznajmljivanja")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public List<TerminIznajmljivanja> loadAllTermineIznajmljivanja() {
        return this.voziloService.findAllTermineIznajmljivanja();
    }

    @PutMapping(value = "/user/agent/dodajKM/{dodatiKM}")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity addKm (@Valid @RequestBody VoziloDTO voziloDTO, @PathVariable Double dodatiKM) {
        voziloService.addKmToVehicle(voziloDTO, dodatiKM);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allVozila/kaca")
    @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public ResponseEntity<?> findAllVozila() throws AccessDeniedException {
        return this.voziloService.findAllVozila();
    }

    @GetMapping(value = "getVozilaAgent")
    public ResponseEntity<?> getAllVozilaAgent(){
        return this.voziloService.getAllVozilaAgent();
    }

}
