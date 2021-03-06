package com.service.impl;

import com.dto.KlasaAutomobilaDTO;
import com.dto.TipMjenjacaDTO;
import com.dto.VrstaGorivaDTO;
import com.model.TipGoriva;
import com.model.TipMjenjaca;
import com.repository.TipMjenjacaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipMjenjacaService {
    @Autowired
    private TipMjenjacaRepository tipMjenjacaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TipMjenjaca findById(Long id) throws AccessDeniedException {
        TipMjenjaca u = tipMjenjacaRepository.findById(id).orElseGet(null);
        return u;
    }

    public TipMjenjaca save(TipMjenjacaDTO mDTO) {
        TipMjenjaca m = new TipMjenjaca();
        m.setNaziv(mDTO.getNaziv());
        m.setObrisan(false);

        m = this.tipMjenjacaRepository.save(m);
        return m;
    }
    public List<TipMjenjacaDTO> findAll() throws AccessDeniedException {
        List<TipMjenjaca> result = tipMjenjacaRepository.findAll();
        List<TipMjenjacaDTO> finalResult = new ArrayList<>();
        for(TipMjenjaca tipMjenjaca : result){
            if(!tipMjenjaca.getObrisan()){
                finalResult.add(modelMapper.map(tipMjenjaca, TipMjenjacaDTO.class));
            }
        }
        return finalResult;
    }

    public TipMjenjaca edit(TipMjenjacaDTO tipMjenjacaDTO){
        TipMjenjaca tipMenjaca = this.findById(tipMjenjacaDTO.getId());
        tipMenjaca.setId(tipMjenjacaDTO.getId());
        tipMenjaca.setNaziv(tipMjenjacaDTO.getNaziv());
        this.tipMjenjacaRepository.save(tipMenjaca);
        return tipMenjaca;
    }

    public void delete (Long id){
        TipMjenjaca tipMjenjaca = this.findById(id);
        tipMjenjaca.setObrisan(true);
        this.tipMjenjacaRepository.save(tipMjenjaca);
    }

    public ResponseEntity<?> getAll() {

        List<TipMjenjaca> result = tipMjenjacaRepository.findAll();
        List<TipMjenjacaDTO> tipMjenjacaDTOS = new ArrayList<>();

        for(TipMjenjaca m: result){
            tipMjenjacaDTOS.add(modelMapper.map(m, TipMjenjacaDTO.class));
        }

        return new ResponseEntity<>(tipMjenjacaDTOS, HttpStatus.OK);
    }
}
