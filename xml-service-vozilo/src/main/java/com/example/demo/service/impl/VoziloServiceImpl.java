package com.example.demo.service.impl;

import com.example.demo.dto.VoziloDTO;
import com.example.demo.model.Vozilo;
import com.example.demo.repository.VoziloRepository;
import com.example.demo.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;

    @Override
    public List<Vozilo> findAll() {
        List<Vozilo> result = voziloRepository.findAll();
        return result;
    }

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

    @Override
    public Vozilo delete(VoziloDTO voziloDTO) {
        return null;
    }

}
