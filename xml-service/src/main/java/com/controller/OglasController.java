package com.controller;

import com.model.Oglas;
import com.service.OglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/oglasi", produces = MediaType.APPLICATION_JSON_VALUE)
public class OglasController {

    @Autowired
    private OglasService oglasService;

    @GetMapping("/allAds")
   // @PreAuthorize("hasRole('ROLE_KORISNIK')")
    public List<Oglas> findAll() throws AccessDeniedException {
        return this.oglasService.findAll();
    }


}
