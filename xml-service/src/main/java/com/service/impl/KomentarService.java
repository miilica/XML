package com.service.impl;

import com.dto.KomentarDTO;
import com.model.Agent;
import com.model.Komentar;
import com.model.User;
import com.model.Vozilo;
import com.repository.AgentRepository;
import com.repository.KomentarRepository;
import com.repository.UserRepository;
import com.repository.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public ResponseEntity<?> kreirajKomentar(KomentarDTO komentarDTO) {
        Komentar komentar = new Komentar();
        komentar.setOdobren(true);
        komentar.setTekst(komentarDTO.getTekst());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //Agent agent = this.agentRepository.getOne(6l);

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
            KomentarDTO komentarDTO = KomentarDTO.builder()
                    .id(k.getId())
                    .odobren(k.isOdobren())
                    .tekst(k.getTekst())
                    .userId(k.getUserId())
                    .userUsername(user.getUsername())
                    .build();
            komentariDTO.add(komentarDTO);
        }
        return  new ResponseEntity<>(komentariDTO, HttpStatus.OK);
    }
}
