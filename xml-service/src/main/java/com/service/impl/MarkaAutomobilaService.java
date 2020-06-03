package com.service.impl;

import com.dto.MarkaAutomobilaDTO;
import com.model.MarkaAutomobila;
import com.repository.MarkaAutomobilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class MarkaAutomobilaService {
    @Autowired
    private MarkaAutomobilaRepository markaAutomobilaRepository;

    public MarkaAutomobila findById(Long id) throws AccessDeniedException {
        MarkaAutomobila u = markaAutomobilaRepository.findById(id).orElseGet(null);
        return u;
    }


    public MarkaAutomobila save(MarkaAutomobilaDTO mDTO) {
        MarkaAutomobila m = new MarkaAutomobila();
        m.setModel(mDTO.getModel());
        m.setNazivMarke(mDTO.getNazivMake());

        m = this.markaAutomobilaRepository.save(m);
        return m;
    }
}
