package com.example.demo.service;

import com.example.demo.dto.OglasDTO;
import com.example.demo.dto.PretragaDTO;
import com.example.demo.model.Oglas;
import com.example.demo.repository.PretragaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PretragaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PretragaRepository pretragaRepository;

    public ResponseEntity<List<OglasDTO>> pretraga(PretragaDTO pretragaDTO) {

        String mjestoPreuzimanja = pretragaDTO.getMjestoPreuzimanja();
        Date doo = pretragaDTO.getDoo();
        Date od = pretragaDTO.getOd();


        List<Oglas> oglasi = this.pretragaRepository.pretrazi(mjestoPreuzimanja, doo, od);

        List<OglasDTO> oglasiDTO = new ArrayList<>();
        for(Oglas oglas: oglasi){
            oglasiDTO.add(modelMapper.map(oglas, OglasDTO.class));
        }

        return new ResponseEntity<>(oglasiDTO, HttpStatus.OK);
    }
}
