package com.example.demo.service;

import com.example.demo.dto.KlasaAutomobilaDTO;
import com.example.demo.model.KlasaAutomobila;
import com.example.demo.repository.KlasaAutoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KlasaAutomobilaService {

    @Autowired
    private KlasaAutoRepository klasaAutoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public KlasaAutomobila findById(Long id) throws AccessDeniedException {
        KlasaAutomobila u = klasaAutoRepository.findById(id).orElseGet(null);
        return u;
    }


    public KlasaAutomobila save(KlasaAutomobilaDTO mDTO) {
        KlasaAutomobila m = new KlasaAutomobila();
        m.setNaziv(mDTO.getNaziv());
        m.setObrisan(false);

        m = this.klasaAutoRepository.save(m);
        return m;
    }

    public List<KlasaAutomobilaDTO> findAll() throws AccessDeniedException {
        List<KlasaAutomobila> result = klasaAutoRepository.findAll();
        List<KlasaAutomobilaDTO>finalResult = new ArrayList<>();
        for(KlasaAutomobila klasaAutomobila : result){
            if(!klasaAutomobila.getObrisan()){
                finalResult.add(modelMapper.map(klasaAutomobila, KlasaAutomobilaDTO.class));
            }
        }
        return finalResult;
    }

    public KlasaAutomobila edit(KlasaAutomobilaDTO klasaAutomobilaDTO) throws AccessDeniedException {
        KlasaAutomobila klasaAutomobila = this.findById(klasaAutomobilaDTO.getID());
        klasaAutomobila.setId(klasaAutomobilaDTO.getID());
        klasaAutomobila.setNaziv(klasaAutomobilaDTO.getNaziv());
        this.klasaAutoRepository.save(klasaAutomobila);
        return klasaAutomobila;
    }

    public void delete(Long id) throws AccessDeniedException {
        KlasaAutomobila klasaAutomobila = this.findById(id);
        klasaAutomobila.setObrisan(true);
        this.klasaAutoRepository.save(klasaAutomobila);
        //return "Obrisana klasa automobila";
    }

    public ResponseEntity<?> getAll() {
        List<KlasaAutomobila> result = klasaAutoRepository.findAll();
        List<KlasaAutomobilaDTO> klasaAutomobilaDTOS = new ArrayList<>();

        for(KlasaAutomobila k: result){
            if(!k.getObrisan()) {
                klasaAutomobilaDTOS.add(modelMapper.map(k, KlasaAutomobilaDTO.class));
            }
        }

        return new ResponseEntity<>(klasaAutomobilaDTOS, HttpStatus.OK);
    }
}
