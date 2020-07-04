package com.service.impl;

import com.dto.OglasDTO;
import com.model.Agent;
import com.model.Oglas;
import com.model.User;
import com.model.Vozilo;
import com.repository.OglasRepository;
import com.service.OglasService;
import com.service.UserService;
import com.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class OglasServiceImpl implements OglasService {

    @Autowired
    private OglasRepository oglasRepository;

    @Autowired
    private VoziloService voziloService;

    @Autowired
    private UserService userService;

    @Autowired
    private  AgentService agentService;

    @Override
    public Oglas findById(Long id) {
        return null;
    }

    public List<Oglas> findAll() throws AccessDeniedException {
        List<Oglas> result = oglasRepository.findAll();
        return result;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResponseEntity<Void> noviOglas(OglasDTO oglasDTO) {
        Vozilo vozilo = this.voziloService.findById(oglasDTO.getVozilo().getId());
        //PriceList priceList = this.priceListService.getPriceListById(adDTO.getPriceListId());
        User user = userService.findById(oglasDTO.getUserId());
        Agent pom = agentService.findById(oglasDTO.getUserId());
        if(pom.getImeKompanije() == null || pom.getImeKompanije().equals("")){
            System.out.println("null");
            if(user.getOglasi().size()>2){
                return new ResponseEntity<>(HttpStatus.valueOf("Korisnik ne moze dodati vise od 3 oglasa"));
            }
        }


        Oglas oglas = new Oglas();
        oglas.setVozilo(vozilo);
       oglas.setDostupan(oglasDTO.isDostupan());
        oglas.setFromDate(oglasDTO.getFromDate());
        oglas.setToDate(oglasDTO.getToDate());
        oglas.setMjestoPreuzimanja(oglasDTO.getMestoPreuzimanja());
        oglas.setUser(user);
        //ad.setPriceList(priceList);




        this.oglasRepository.save(oglas);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
