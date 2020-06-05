package com.service.impl;

import com.dto.VoziloDTO;
import com.model.*;
import com.repository.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoziloService {
    @Autowired
    private VoziloRepository voziloRepository;

    public Vozilo findById(Long id) throws AccessDeniedException {
        Vozilo u = voziloRepository.findById(id).orElseGet(null);
        return u;
    }


    public Vozilo save(VoziloDTO vDTO) {
        Vozilo m = new Vozilo();
        m.setCijena(vDTO.getCijena());
        m.setKilometraza(vDTO.getKilometraza());
        m.setMozePreciKM(vDTO.getMozePreciKM());
        m.setBrSjedistaZaDjecu(vDTO.getBrSjedistaZaDjecu());
        m.setOcjena(vDTO.getOcjena());
      //  m.setMarkaAutomobila(new MarkaAutomobila(vDTO.getMarkaAutomobila()));
       // m.setKlasaAutomobila(1);
    //    m.setTipGoriva(new TipGoriva(vDTO.getTipGoriva()));
      //  m.setTipMjenjaca(new TipMjenjaca(vDTO.getTipMjenjaca()));
        m.setImaAndroid(vDTO.getImaAndroid());
        m.setColiisionDamageWavier(vDTO.isColiisionDamageWavier());
        m = this.voziloRepository.save(m);
        return m;
    }
    public List<Vozilo> findAll() throws AccessDeniedException {
        List<Vozilo> result = voziloRepository.findAll();
        return result;
    }
}
