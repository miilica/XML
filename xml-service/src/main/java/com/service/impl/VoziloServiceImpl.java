package com.service.impl;

import com.dto.MarkaAutomobilaDTO;
import com.dto.VoziloDTO;
import com.dto.ZauzeceDTO;
import com.model.*;
import com.repository.AgentRepository;
import com.repository.KorpaVozilaRepository;
import com.repository.VoziloRepository;
import com.service.VoziloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<Vozilo> findAll() {
        List<Vozilo> result = voziloRepository.findAll();
        return result;
    }

    public ResponseEntity<?> findAllVozila(){

        List<Vozilo> vozila = this.voziloRepository.findAll();
        List<VoziloDTO> vozilaDTO = new ArrayList<>();

        for(Vozilo v: vozila){
            VoziloDTO voziloDTO = new ModelMapper().map(v, VoziloDTO.class);
            vozilaDTO.add(voziloDTO);
        }

        return new ResponseEntity<>(vozilaDTO,HttpStatus.OK);
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

    public Vozilo getVozilo(Long id){
        Vozilo vozilo = voziloRepository.getOne(id);
        return vozilo;
    }


    public ResponseEntity<?> getAllVozilaAgent() {

        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //Object object = authentication.getPrincipal();

        Agent agent = this.agentRepository.getOne(6l);

        List<Vozilo> vozila = this.voziloRepository.findAllByAgentId(agent.getId());
        List<VoziloDTO> voziloDTOS = new ArrayList<>();

        for(Vozilo v: vozila){
            VoziloDTO vDTO = new VoziloDTO();
            vDTO.setId(v.getId());

            vDTO.setMarkaAutomobila(modelMapper.map(v.getMarkaAutomobila(), MarkaAutomobilaDTO.class));

            voziloDTOS.add(vDTO);
        }

        return new ResponseEntity<>(voziloDTOS,HttpStatus.OK);
    }
}
