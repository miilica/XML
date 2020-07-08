package com.service.impl;

import com.dto.KlasaAutomobilaDTO;
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
        m.setNazivMarke(mDTO.getNazivMarke());
        m.setObrisan(false);
        m = this.markaAutomobilaRepository.save(m);
        return m;
    }
    public List<MarkaAutomobilaDTO> findAll() throws AccessDeniedException {
        List<MarkaAutomobila> result = markaAutomobilaRepository.findAll();
        List<MarkaAutomobilaDTO> finalResult = new ArrayList<>();
        for(MarkaAutomobila markaAutomobila: result){
            if(!markaAutomobila.getObrisan()){
                finalResult.add(modelMapper.map(markaAutomobila, MarkaAutomobilaDTO.class));

            }
        }
        return finalResult;
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
    public MarkaAutomobila edit(MarkaAutomobilaDTO markaAutomobilaDTO){
        MarkaAutomobila markaAutomobila = this.findById(markaAutomobilaDTO.getId());
        markaAutomobila.setId(markaAutomobilaDTO.getId());
        markaAutomobila.setModel(markaAutomobilaDTO.getModel());
        markaAutomobila.setNazivMarke(markaAutomobilaDTO.getNazivMarke());
        this.markaAutomobilaRepository.save(markaAutomobila);
        return markaAutomobila;
    }

    public void delete(Long id){
        MarkaAutomobila markaAutomobila = this.findById(id);
        markaAutomobila.setObrisan(true);
        this.markaAutomobilaRepository.save(markaAutomobila);
    }

}
