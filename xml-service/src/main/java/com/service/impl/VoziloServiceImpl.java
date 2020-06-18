package com.service.impl;

import com.dto.VoziloDTO;
import com.model.*;
import com.repository.TerminIznajmljivanjaRepository;
import com.repository.UserRepository;
import com.repository.VoziloRepository;
import com.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TerminIznajmljivanjaRepository terminIznajmljivanjaRepository;

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
    public List<TerminIznajmljivanja> findAllTermineIznajmljivanja() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object currentUser = auth.getPrincipal();

        String username = "";
        if (currentUser instanceof UserDetails) {
            username = ((UserDetails)currentUser).getUsername();
        } else {
            username = currentUser.toString();
        }

        User u = userRepository.findByUsername(username);

        List<TerminIznajmljivanja> all = terminIznajmljivanjaRepository.findAll();
        List<TerminIznajmljivanja> result = new ArrayList<>();
        Date currentUtilDate = new Date();

        for(TerminIznajmljivanja ti : all) {
            if(ti.getVozilo().getAgent().getId() == u.getId()) {
                if(ti.getDoKad().before(currentUtilDate)) {
                    result.add(ti);
                }
            }
        }

        return result;
    }

    @Override
    public Vozilo addKmToVehicle(VoziloDTO voziloDTO, Double predjeniKM){
        Vozilo vozilo = voziloRepository.findById(voziloDTO.getId()).orElseGet(null);
        Double km = vozilo.getKilometraza() + predjeniKM;
        vozilo.setKilometraza(km);
        vozilo = voziloRepository.save(vozilo);

        return vozilo;
    }

}
