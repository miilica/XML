package com.service.impl;

import com.dto.TerminIznajmljivanjaDTO;
import com.model.Oglas;
import com.model.TerminIznajmljivanja;
import com.model.Vozilo;
import com.repository.TerminIznajmljivanjaRepository;
import com.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TerminIznajmljivanjaServis {

    @Autowired
    private TerminIznajmljivanjaRepository terminIznajmljivanjaRepository;
    @Autowired
    private VoziloService voziloService;


    public ResponseEntity<Void> newTerminIznajmljivanja(TerminIznajmljivanjaDTO terminIznajmljivanjaDTO) {
        TerminIznajmljivanja terminIznajmljivanja = new TerminIznajmljivanja();
        terminIznajmljivanja.setDateFrom(terminIznajmljivanjaDTO.getDateFrom());
        terminIznajmljivanja.setDateTo(terminIznajmljivanjaDTO.getDateTo());

        Vozilo vozilo = voziloService.findById(terminIznajmljivanjaDTO.getVoziloId());
        terminIznajmljivanja.setVozilo(vozilo);

        for (Oglas oglas: vozilo.getOglasi()){
            terminIznajmljivanjaDTO.getOglasId().add(oglas.getId());
        }

        terminIznajmljivanja = this.terminIznajmljivanjaRepository.save(terminIznajmljivanja);


    /*    try {
            this.requestClient.occupiedRequests(occupiedDTO);
            log.info("Successufully called request service");
        } catch (FeignException.NotFound e) {
            log.info("Error calling request service");
        }*/

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<TerminIznajmljivanjaDTO> gettTermineIznajmljivanja(Long id) {
        TerminIznajmljivanja terminIznajmljivanja = terminIznajmljivanjaRepository.getOne(id);
        TerminIznajmljivanjaDTO terminIznajmljivanjaDTO = new TerminIznajmljivanjaDTO();
        terminIznajmljivanjaDTO.setDateTo(terminIznajmljivanja.getDateTo());
        terminIznajmljivanjaDTO.setDateFrom(terminIznajmljivanja.getDateFrom());
        terminIznajmljivanjaDTO.setVoziloId(terminIznajmljivanja.getVozilo().getId());
        terminIznajmljivanjaDTO.setId(terminIznajmljivanja.getId());

        return new ResponseEntity<>(terminIznajmljivanjaDTO, HttpStatus.FOUND);
    }

}
