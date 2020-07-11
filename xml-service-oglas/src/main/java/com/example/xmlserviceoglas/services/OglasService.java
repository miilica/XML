package com.example.xmlserviceoglas.services;

import com.example.xmlserviceoglas.dto.OglasDTO;
import com.example.xmlserviceoglas.dto.OglasInfoDTO;
import com.example.xmlserviceoglas.generated.PostOglasRequest;
import com.example.xmlserviceoglas.generated.TOglas;
import com.example.xmlserviceoglas.model.*;
import com.example.xmlserviceoglas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class OglasService {

    @Autowired
    private OglasRepository oglasRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoziloRepository voziloRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private CjenovnikRepository cjenovnikRepository;

    //za soap
    public long noviOglas(PostOglasRequest oglasRequest) {
        TOglas tOglas = oglasRequest.getOglasRequest();

        return 1;
    }

    public List<Oglas> findAll() throws AccessDeniedException {
        List<Oglas> result = oglasRepository.findAll();
        return result;
    }

    public ResponseEntity<Void> noviOglas(OglasDTO oglasDTO) {
        Vozilo vozilo = this.voziloRepository.findById(oglasDTO.getVozilo().getId()).orElseGet(null);
        Cjenovnik cjenovnik = this.cjenovnikRepository.getOne(oglasDTO.getCjenovnikID());
        User user = userRepository.findById(oglasDTO.getUserId()).orElseGet(null);
        Agent pom = agentRepository.getOne(oglasDTO.getUserId());
        if(pom.getImeKompanije() == null || pom.getImeKompanije().equals("")){
            System.out.println("null");
            if(user.getOglasi().size()>2){
                return new ResponseEntity<>(HttpStatus.valueOf("Korisnik ne moze dodati vise od 3 oglasa"));
            }
        }

        Oglas oglas = new Oglas();
        oglas.setVozilo(vozilo);
        oglas.setDostupan(oglasDTO.isDostupan());
        oglas.setOd(oglasDTO.getOd());
        oglas.setDoo(oglasDTO.getDoo());
        oglas.setMjestoPreuzimanja(oglasDTO.getMestoPreuzimanja());
        oglas.setUser(user);
        oglas.setCjenovnik(cjenovnik);

        this.oglasRepository.save(oglas);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
