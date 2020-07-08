package com.service.impl;

import com.dto.VrstaGorivaDTO;
import com.model.TipGoriva;
import com.repository.VrstaGorivaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VrstaGorivaService {
    @Autowired
    private VrstaGorivaRepository vrstaGorivaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TipGoriva findById(Long id) throws AccessDeniedException {
        TipGoriva u = vrstaGorivaRepository.findById(id).orElseGet(null);
        return u;
    }


    public TipGoriva save(VrstaGorivaDTO mDTO) {
        TipGoriva m = new TipGoriva();
        m.setNaziv(mDTO.getNaziv());

        m = this.vrstaGorivaRepository.save(m);
        return m;
    }

    public List<TipGoriva> findAll() throws AccessDeniedException {
        List<TipGoriva> result = vrstaGorivaRepository.findAll();
        return result;
    }

    public ResponseEntity<?> getAll() {
        List<TipGoriva> result = vrstaGorivaRepository.findAll();
        List<VrstaGorivaDTO> vrstaGorivaDTOS = new ArrayList<>();

        for(TipGoriva t: result){
            vrstaGorivaDTOS.add(modelMapper.map(t, VrstaGorivaDTO.class));
        }

        return new ResponseEntity<>(vrstaGorivaDTOS, HttpStatus.OK);
    }
}
