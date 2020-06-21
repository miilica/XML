package com.service.impl;

import com.dto.VoziloDTO;
import com.model.*;
import com.repository.TerminIznajmljivanjaRepository;
import com.repository.UserRepository;
import com.dto.ZauzeceDTO;
import com.model.KorpaVozila;
import com.model.Oglas;
import com.model.Vozilo;
import com.model.Zauzece;
import com.repository.KorpaVozilaRepository;
import com.repository.VoziloRepository;
import com.service.VoziloService;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;
    private MarkaAutomobilaService markaAutomobilaService;
    private VrstaGorivaService vrstaGorivaService;
    private KlasaAutomobilaService klasaAutomobilaService;
    private  TipMjenjacaService tipMjenjacaService;

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

    public Vozilo save(VoziloDTO carDTO) throws SQLException, Base64DecodingException {

        MarkaAutomobila markaAutomobilak = this.markaAutomobilaService.findById(carDTO.getMarkaAutomobila().getId());
        TipGoriva gorivo = this.vrstaGorivaService.findById(carDTO.getTipGoriva().getId());
        KlasaAutomobila klasaAutomobila = this.klasaAutomobilaService.findById(carDTO.getKlasaAutomobila().getID());
        TipMjenjaca tipMjenjaca = this.tipMjenjacaService.findById(carDTO.getTipMjenjaca().getId());

        Set<Slika> slike = new HashSet<>();
        for (String slika: carDTO.getSlike()) {
            Slika pom = extractImage(slika);
            slike.add(pom);
        }

        Vozilo vozilo = new Vozilo();
        vozilo.setCijena(carDTO.getCijena());
        vozilo.setKilometraza(carDTO.getKilometraza());
        vozilo.setMozePreciKM(carDTO.getMozePreciKM());
        vozilo.setBrSjedistaZaDjecu(carDTO.getBrSjedistaZaDjecu());
        vozilo.setOcjena(carDTO.getOcjena());
        vozilo.setMarkaAutomobila(markaAutomobilak);
        vozilo.setTipMjenjaca(tipMjenjaca);
        vozilo.setKlasaAutomobila(klasaAutomobila);
        vozilo.setTipGoriva(gorivo);
        vozilo.setImaAndroid(carDTO.getImaAndroid());
        vozilo.setColiisionDamageWavier(carDTO.isColiisionDamageWavier());
        vozilo.setSlike(slike);
        vozilo = this.voziloRepository.save(vozilo);
        return vozilo;
    }
    public Slika extractImage(String string) throws SQLException, Base64DecodingException {
        String[] parts = string.split(",");
        byte[] decodedByte = Base64.decode(parts[1]);
        String[] info = parts[0].split("/");
        String type = info[1].split(";")[0];
        Slika myImage = new Slika();
        myImage.setImage(new SerialBlob(decodedByte));
        myImage.setInfo(parts[0]);
        myImage.setTip(type);
        return myImage;
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

    public Vozilo getVozilo(Long id){
        Vozilo vozilo = voziloRepository.getOne(id);
        return vozilo;
    }

}
