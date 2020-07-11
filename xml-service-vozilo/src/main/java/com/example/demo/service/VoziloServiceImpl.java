package com.example.demo.service;


import com.example.demo.dto.MarkaAutomobilaDTO;
import com.example.demo.dto.VoziloDTO;
import com.example.demo.model.*;
import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.TerminIznajmljivanjaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VoziloRepository;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.*;

@Service
public class VoziloServiceImpl{

    @Autowired
    private VoziloRepository voziloRepository;
    @Autowired
    private MarkaAutomobilaService markaAutomobilaService;
    @Autowired
    private VrstaGorivaService vrstaGorivaService;
    @Autowired
    private KlasaAutomobilaService klasaAutomobilaService;
    @Autowired
    private  TipMjenjacaService tipMjenjacaService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TerminIznajmljivanjaRepository terminIznajmljivanjaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AgentRepository agentRepository;

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

    public Vozilo dodajNovoVozilo(VoziloDTO carDTO) throws SQLException, Base64DecodingException, AccessDeniedException {

        System.out.println("marka "+carDTO.getMarkaAutomobila().getId());
        MarkaAutomobila markaAutomobilak = this.markaAutomobilaService.findById(carDTO.getMarkaAutomobila().getId());

        System.out.println("gorivo"+carDTO.getTipGoriva().getId() + markaAutomobilak.getNazivMarke());
        TipGoriva gorivo = this.vrstaGorivaService.findById(carDTO.getTipGoriva().getId());

        System.out.println("klasa"+carDTO.getKlasaAutomobila().getID() + gorivo.getNaziv());
        KlasaAutomobila klasaAutomobila = this.klasaAutomobilaService.findById(carDTO.getKlasaAutomobila().getID());

        System.out.println("mjenjac"+carDTO.getTipMjenjaca().getId() + klasaAutomobila.getNaziv());
        TipMjenjaca tipMjenjaca = this.tipMjenjacaService.findById(carDTO.getTipMjenjaca().getId());
        System.out.println("mjenjac"+ tipMjenjaca.getNaziv());

        System.out.println(markaAutomobilak.getId()+gorivo.getId()+klasaAutomobila.getId()+tipMjenjaca.getId());

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
                if(ti.getDateFrom().isBeforeNow()) {
                    result.add(ti);
                }
            }
        }

        return result;
    }


    public Vozilo addKmToVehicle(VoziloDTO voziloDTO, Double predjeniKM) {
        Vozilo vozilo = voziloRepository.findById(voziloDTO.getId()).orElseGet(null);
        Double km = vozilo.getKilometraza() + predjeniKM;
        vozilo.setKilometraza(km);
        vozilo = voziloRepository.save(vozilo);
        return vozilo;
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
