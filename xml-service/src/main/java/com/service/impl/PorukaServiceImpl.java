package com.service.impl;

import com.dto.PorukaDTO;
import com.model.Poruka;
import com.repository.PorukaRepository;
import com.service.PorukaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PorukaServiceImpl implements PorukaService {
    @Autowired
    private PorukaRepository porukaRepository;

    @Override
    public void novaPoruka(){

    };

    @Override
    public void getByUser(){

    };

    @Override
    public void posaljiPoruku(PorukaDTO porukaDTO) {
        Poruka poruka = new Poruka();
        poruka.setSadrzaj(porukaDTO.getSadrzaj());
        Date date = new Date();
        poruka.setDatum(date);
        poruka.setPosiljalacId(porukaDTO.getPosiljalacId());
        poruka.setPrimalacId(porukaDTO.getPrimalacId());
        poruka.setOglasId(porukaDTO.getOglasId());
        porukaRepository.save(poruka);
    }



    @Override
    public List<PorukaDTO> get(Long posiljalacId, Long primalacId, Long oglasId){
        List<Poruka> messages = porukaRepository.findAll();
        List<PorukaDTO> messageDTOS = new ArrayList<>();
        for(Poruka por : messages){
            if((por.getPosiljalacId().equals(posiljalacId) && por.getPrimalacId().equals(primalacId) && por.getOglasId().equals(oglasId)) || (por.getPosiljalacId().equals(primalacId) && por.getPrimalacId().equals(posiljalacId) && por.getOglasId().equals(oglasId))){
                PorukaDTO messageDTO = new PorukaDTO(por.getId(), por.getSadrzaj(), por.getDatum(), por.getPosiljalacId(), por.getPrimalacId(), por.getOglasId());
                messageDTOS.add(messageDTO);
            }
        }

        return messageDTOS;
    };

//    @Override
//    public  List<PorukaDTO> getMojePoruke(Long id){
//        List<PorukaDTO> poruke = porukaRepository.findAllByPrimalacId(id);
//        return  poruke;
//    }
}
