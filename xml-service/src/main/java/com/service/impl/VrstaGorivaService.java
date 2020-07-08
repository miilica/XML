package com.service.impl;

import com.dto.VrstaGorivaDTO;
import com.model.TipGoriva;
import com.repository.VrstaGorivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VrstaGorivaService {
        @Autowired
        private VrstaGorivaRepository vrstaGorivaRepository;

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
        List<TipGoriva> finalResult = new ArrayList<>();
        for(TipGoriva tipGoriva : result){
            if(!tipGoriva.getObrisan()){
                finalResult.add(tipGoriva);
            }
        }
        return finalResult;
    }

    public TipGoriva edit(VrstaGorivaDTO vrstaGorivaDTO){
        TipGoriva tipGoriva = this.findById(vrstaGorivaDTO.getId());
        tipGoriva.setId(vrstaGorivaDTO.getId());
        tipGoriva.setNaziv(vrstaGorivaDTO.getNaziv());
        this.vrstaGorivaRepository.save(tipGoriva);
        return tipGoriva;
    }

    public void delete(Long id){
            TipGoriva tipGoriva = this.findById(id);
            tipGoriva.setObrisan(true);
            this.vrstaGorivaRepository.save(tipGoriva);
    }
}
