package com.example.xmlserviceoglas.controller;

import com.example.xmlserviceoglas.dto.CjenovnikDTO;
import com.example.xmlserviceoglas.services.CjenovnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/cjenovnik")
public class CjenovnikController {

    @Autowired
    private CjenovnikService cjenovnikService;

    @PostMapping("/dodaj")
    private ResponseEntity<?> dodajCjenovnik(@RequestBody CjenovnikDTO cjenovnikDTO){
        return this.cjenovnikService.dodajCjenovnik(cjenovnikDTO);
    }

    @PutMapping("/izmjeni")
    private ResponseEntity<?> izmjeniCjenovnik(@RequestBody CjenovnikDTO cjenovnikDTO){

        return this.cjenovnikService.izmjeniCjenovnik(cjenovnikDTO);
    }

    @GetMapping(value = "/getCjenovnik/{username}")
    private ResponseEntity<?> getCjenovnik(@PathVariable String username){
        return this.cjenovnikService.getCjenovnik(username);
    }



}
