package com.service.impl;

import com.dto.KlasaAutomobilaDTO;
import com.model.KlasaAutomobila;
import com.repository.KlasaAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<KlasaAutomobila> findAll() throws AccessDeniedException {
        List<KlasaAutomobila> result = klasaAutoRepository.findAll();
        List<KlasaAutomobila>finalResult = new ArrayList<>();
        for(KlasaAutomobila klasaAutomobila : result){
            if(!klasaAutomobila.getObrisan()){
                finalResult.add(klasaAutomobila);
            }
        }
        return finalResult;
    }

    public KlasaAutomobila edit(KlasaAutomobilaDTO klasaAutomobilaDTO){
        KlasaAutomobila klasaAutomobila = this.findById(klasaAutomobilaDTO.getID());
        klasaAutomobila.setId(klasaAutomobilaDTO.getID());
        klasaAutomobila.setNaziv(klasaAutomobilaDTO.getNaziv());
        this.klasaAutoRepository.save(klasaAutomobila);
        return klasaAutomobila;
    }

    public void delete(Long id){
        KlasaAutomobila klasaAutomobila = this.findById(id);
        klasaAutomobila.setObrisan(true);
        this.klasaAutoRepository.save(klasaAutomobila);
        //return "Obrisana klasa automobila";
    }
}
