package com.example.demo.service;


import com.example.demo.dto.KomentarDTO;
import com.example.demo.dto.VoziloDTO;
import com.example.demo.model.Komentar;
import com.example.demo.model.User;
import com.example.demo.model.Vozilo;
import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.KomentarRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KomentarService {
    private KomentarRepository komentarRepository;
    private VoziloRepository voziloRepository;
    private AgentRepository agentRepository;
    private UserRepository userRepository;

    @Autowired
    public KomentarService(KomentarRepository komentarRepository, VoziloRepository voziloRepository, AgentRepository agentRepository, UserRepository userRepository) {
        this.komentarRepository = komentarRepository;
        this.voziloRepository = voziloRepository;
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> kreirajKomentar(KomentarDTO komentarDTO, String username) {
        Komentar komentar = new Komentar();
        komentar.setOdobren(false);
        komentar.setTekst(komentarDTO.getTekst());


        User user = this.userRepository.findByUsername(username);
        komentar.setUserId(user.getId());

        Vozilo vozilo = this.voziloRepository.getOne(komentarDTO.getVozilo().getId());
        komentar.setVozilo(vozilo);

        this.komentarRepository.save(komentar);

        return new ResponseEntity<>("Komentar uspjesno kreiran",HttpStatus.CREATED);
    }

    public ResponseEntity<?> pokupiKomentare(Long id) {
        List<Komentar> komentari = this.komentarRepository.findAllByVoziloIdAndOdobren(id, true);
        List<KomentarDTO> komentariDTO = new ArrayList<>();

        for(Komentar k: komentari){
            User user = this.userRepository.getOne(k.getUserId());
            KomentarDTO komentarDTO = new KomentarDTO(k);
            komentariDTO.add(komentarDTO);
        }
        return  new ResponseEntity<>(komentariDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> pokupiSveKomentare() {
        List<Komentar> komentari = this.komentarRepository.findAllByOdobren(false);
        List<KomentarDTO> komentariDTO = new ArrayList<>();

        for(Komentar k: komentari){
            User user = this.userRepository.getOne(k.getUserId());
            KomentarDTO komentarDTO = new KomentarDTO(k);

            komentariDTO.add(komentarDTO);
        }
        return  new ResponseEntity<>(komentariDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> odobriKomentar(Boolean flag, Long id) {
        if(flag == true){
            Komentar komentar = this.komentarRepository.getOne(id);
            komentar.setOdobren(true);
            this.komentarRepository.save(komentar);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            this.komentarRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
