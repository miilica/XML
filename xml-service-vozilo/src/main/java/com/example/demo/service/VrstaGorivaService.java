package com.example.demo.service;


import com.example.demo.dto.VrstaGorivaDTO;
import com.example.demo.model.TipGoriva;
import com.example.demo.repository.VrstaGorivaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
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
        m.setObrisan(false);

        m = this.vrstaGorivaRepository.save(m);
        return m;
    }

    public List<VrstaGorivaDTO> findAll() throws AccessDeniedException {
        List<TipGoriva> result = vrstaGorivaRepository.findAll();
        List<VrstaGorivaDTO> finalResult = new ArrayList<>();
        for(TipGoriva tipGoriva : result){
            if(!tipGoriva.getObrisan()){
                finalResult.add(modelMapper.map(tipGoriva, VrstaGorivaDTO.class));
            }
        }
        return finalResult;
    }

    public TipGoriva edit(VrstaGorivaDTO vrstaGorivaDTO) throws AccessDeniedException {
        TipGoriva tipGoriva = this.findById(vrstaGorivaDTO.getId());
        tipGoriva.setId(vrstaGorivaDTO.getId());
        tipGoriva.setNaziv(vrstaGorivaDTO.getNaziv());
        this.vrstaGorivaRepository.save(tipGoriva);
        return tipGoriva;
    }

    public void delete(Long id) throws AccessDeniedException {
            TipGoriva tipGoriva = this.findById(id);
            tipGoriva.setObrisan(true);
            this.vrstaGorivaRepository.save(tipGoriva);
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
