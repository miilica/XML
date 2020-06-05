package com.example.demo.controller;

import com.example.demo.dto.PretragaDTO;
import com.example.demo.service.PretragaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pretraga")
public class PretragaController {

    @Autowired
    private PretragaService pretragaService;

    @PostMapping()
    public ResponseEntity<?> pretraga(@RequestBody PretragaDTO pretragaDTO){

        return this.pretragaService.pretraga(pretragaDTO);
    }
}
