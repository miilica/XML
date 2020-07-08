package com.service.impl;

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

        m = this.tipMjenjacaRepository.save(m);
        return m;
    }
    public List<TipMjenjaca> findAll() throws AccessDeniedException {
        List<TipMjenjaca> result = tipMjenjacaRepository.findAll();
        return result;
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
