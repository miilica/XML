package com.service.impl;

import com.dto.ZauzeceDTO;
import com.model.Oglas;
import com.model.Vozilo;
import com.model.Zauzece;
import com.repository.ZauzeceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ZauzeceService {

    @Autowired
    private ZauzeceRepository zauzeceRepository;

    @Autowired
    private VoziloServiceImpl voziloService;

    public ResponseEntity<?> getZauzece(Long id) {
        Zauzece zauzece = zauzeceRepository.getOne(id);
        ZauzeceDTO zauzeceDTO = new ZauzeceDTO();

        zauzeceDTO.setId(zauzece.getId());
        zauzeceDTO.setZauzetOd(zauzece.getZauzetOd());
        zauzeceDTO.setZauzetDo(zauzece.getZauzetDo());
        zauzeceDTO.setVoziloId(zauzece.getVozilo().getId());

        return new ResponseEntity<>(zauzeceDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> zauzeceAutomobila(ZauzeceDTO zauzeceDTO) {

        Zauzece zauzece = new Zauzece();
        zauzece.setZauzetOd(zauzeceDTO.getZauzetOd());
        zauzece.setZauzetDo(zauzeceDTO.getZauzetDo());

        Vozilo vozilo = voziloService.getVozilo(zauzeceDTO.getVoziloId());
        zauzece.setVozilo(vozilo);

        for(Oglas o: vozilo.getOglasi()){
            zauzeceDTO.getOglasId().add(o.getId());
        }

        zauzece = this.zauzeceRepository.save(zauzece);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
