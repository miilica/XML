package com.controller;

import com.dto.VoziloDTO;
import com.dto.ZahtjevDTO;
import com.model.Zahtjev;
import com.repository.ZahtjevRepository;
import com.service.ZahtjevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/zahtjev")
public class ZahtjevController {

    @Autowired
    private ZahtjevService zahtjevService;

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @GetMapping("/allZahtjeve")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public List<Zahtjev> findAll() throws AccessDeniedException {
        return this.zahtjevService.findAll();
    }

    @GetMapping("/allZahtjeve/kaca")
    @PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity<?> findAllZahtjeve() throws AccessDeniedException {
        return this.zahtjevService.findAllZahtjeve();
    }


    @GetMapping("/allZahtjeveRateComment")
    //@PreAuthorize("hasRole('ROLE_KORISNIK')")
    public List<Zahtjev> findAllPaid() throws AccessDeniedException {
        return this.zahtjevService.findAllVehiclesToRateComment();
    }

    @PostMapping("/toReserved")
    //@PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity vehicleToReserved(@Valid @RequestBody Zahtjev zahtjev) {
        zahtjevService.vehicleToReserved(zahtjev);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/toReservedBundle")
    //@PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity vehicleToReservedBundle(@Valid @RequestBody Zahtjev zahtjev) {
        zahtjevService.vehicleToReservedBundle(zahtjev);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/toCanceled")
    //@PreAuthorize("hasRole('ROLE_AGENT')")
    public ResponseEntity vehicleToCanceled(@Valid @RequestBody Zahtjev zahtjev) {
        zahtjevService.vehicleToCanceled(zahtjev);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findVehicleById/{vehicleId}/{agentId}")
    //@PreAuthorize("hasRole('ROLE_AGENT')" + "|| hasRole('ROLE_KORISNIK')")
    public ZahtjevDTO loadById(@PathVariable Long vehicleId, @PathVariable Long agentId) {
        return this.zahtjevService.findByIds(vehicleId, agentId);
    }

    @PutMapping(value = "/rateVehicle/{rate}")
    //@PreAuthorize("hasRole('ROLE_KORISNIK')")
    public ResponseEntity rateVehicleGrade (@Valid @RequestBody VoziloDTO voziloDTO, @PathVariable Double rate) {
        zahtjevService.rateVehicle(voziloDTO, rate);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/commentVehicle/{kom}")
    //@PreAuthorize("hasRole('ROLE_KORISNIK')")
    public ResponseEntity commentVehicleGrade (@Valid @RequestBody VoziloDTO voziloDTO, @PathVariable String kom) {
        zahtjevService.commentVehicle(voziloDTO, kom);
        return ResponseEntity.ok().build();
    }
}
