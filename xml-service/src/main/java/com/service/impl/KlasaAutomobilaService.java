package com.service.impl;

import com.dto.KlasaAutomobilaDTO;
import com.model.KlasaAutomobila;
import com.repository.KlasaAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class KlasaAutomobilaService {
    @Autowired
    private KlasaAutoRepository klasaAutoRepository;

    public KlasaAutomobila findById(Long id) throws AccessDeniedException {
        KlasaAutomobila u = klasaAutoRepository.findById(id).orElseGet(null);
        return u;
    }


    public KlasaAutomobila save(KlasaAutomobilaDTO mDTO) {
        KlasaAutomobila m = new KlasaAutomobila();
        m.setNaziv(mDTO.getNaziv());

        m = this.klasaAutoRepository.save(m);
        return m;
    }
}
