package com.controller;

import com.dto.ZauzeceDTO;
import com.service.impl.ZauzeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/zauzece")
public class ZauzeceController {

    @Autowired
    private ZauzeceService zauzeceService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getZauzece(@PathVariable Long id){
        return this.zauzeceService.getZauzece(id);
    }

    @PostMapping(value = "/dodaj")
    public ResponseEntity<?> zauzeceAutomobila(@RequestBody ZauzeceDTO zauzeceDTO){
        return this.zauzeceService.zauzeceAutomobila(zauzeceDTO);
    }


}
