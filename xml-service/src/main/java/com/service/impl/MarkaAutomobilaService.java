package com.service.impl;

import com.dto.MarkaAutomobilaDTO;
import com.dto.VrstaGorivaDTO;
import com.model.MarkaAutomobila;
import com.model.TipGoriva;
import com.repository.MarkaAutomobilaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkaAutomobilaService {
    @Autowired
    private MarkaAutomobilaRepository markaAutomobilaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MarkaAutomobila findById(Long id) throws AccessDeniedException {
        MarkaAutomobila u = markaAutomobilaRepository.findById(id).orElseGet(null);
        return u;
    }


    public MarkaAutomobila save(MarkaAutomobilaDTO mDTO) {
        MarkaAutomobila m = new MarkaAutomobila(mDTO);
        m = this.markaAutomobilaRepository.save(m);
        return m;
    }
    public List<MarkaAutomobila> findAll() throws AccessDeniedException {
        List<MarkaAutomobila> result = markaAutomobilaRepository.findAll();
        return result;
    }


    public ResponseEntity<?> getAll() {

        List<MarkaAutomobila> result = markaAutomobilaRepository.findAll();
        List<MarkaAutomobilaDTO> markaAutomobilaDTOS = new ArrayList<>();

        for(MarkaAutomobila ma: result){
            markaAutomobilaDTOS.add(modelMapper.map(ma, MarkaAutomobilaDTO.class));
        }

        return new ResponseEntity<>(markaAutomobilaDTOS, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllModels(Long markId) {
        List<MarkaAutomobila> result = markaAutomobilaRepository.findAllById(markId);
        List<String> modeli = new ArrayList<>();

        for(MarkaAutomobila ma: result){
            modeli.add(ma.getModel());
        }

        return new ResponseEntity<>(modeli, HttpStatus.OK);

    }
}
