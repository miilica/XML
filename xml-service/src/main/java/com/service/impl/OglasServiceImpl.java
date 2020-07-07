package com.service.impl;

import com.dto.*;
import com.dto.OglasDTO;
import com.model.Agent;
import com.model.Oglas;
import com.model.User;
import com.model.Vozilo;
import com.repository.OglasRepository;
import com.service.OglasService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.service.UserService;
import com.service.VoziloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@Service @Slf4j
public class OglasServiceImpl implements OglasService {

    @Autowired
    private OglasRepository oglasRepository;

    @Autowired

    private ModelMapper modelMapper;

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


    public ResponseEntity<?> pretraziMjesta() {
        List<String> mjesta = new ArrayList<>();
        List<Oglas> oglasi = this.oglasRepository.findAll();

        for(Oglas o: oglasi){
            if(mjesta.contains(o.getMjestoPreuzimanja()))
                continue;

            mjesta.add(o.getMjestoPreuzimanja());
        }

        return new ResponseEntity<>(mjesta, HttpStatus.OK);
    }

    public ResponseEntity<?> pretraziOglase(PretragaDTO pretraga, int page, String sort) {
        if(pretraga.getOd().isAfter(pretraga.getDoo()) || pretraga.getOd().isBefore(DateTime.now())){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<OglasInfoDTO> oglasDTOS = new ArrayList<>();
        String mjesto = pretraga.getMjestoPreuzimanja();
        DateTime od = pretraga.getOd();
        DateTime doo = pretraga.getDoo();
        Long markaId = pretraga.getMarka().getId();
        String model = pretraga.getMarka().getModel();
        Long gorivoId = pretraga.getGorivo().getId();
        Long mjenjacId = pretraga.getMjenjac().getId();
        Long klasaId = pretraga.getKlasa().getID();
        Double cijenaOd = pretraga.getCijenaOd();
        Double cijenaDo = pretraga.getCijenaDo();
        if(cijenaDo == 0)
            cijenaDo = 1000000.0;
        Double kilometrazaDo = pretraga.getKilometrazaDo();
        if (kilometrazaDo == 0)
            kilometrazaDo = 1000000.0;
        Double kilometrazaOd = pretraga.getKilometrazaOd();
        Double kilometrazaDozvoljena = pretraga.getKilometrazaDozvoljena();
        Integer brojMjestaDjeca = pretraga.getBrojDjecijihMjesta();
        Boolean cdw = pretraga.getCdw();

        Sort sortby = sortBy(sort);
        Pageable pageable = PageRequest.of(page, 10, sortby);
        Page<Oglas> oglasi = this.oglasRepository.pretraziOglase(mjesto, od, doo, model, markaId, klasaId, gorivoId, mjenjacId, cijenaOd, cijenaDo,
                kilometrazaOd, kilometrazaDo, kilometrazaDozvoljena, cdw, brojMjestaDjeca, pageable);

        for (Oglas o: oglasi){
            OglasInfoDTO oglasDTO = modelMapper.map(o, OglasInfoDTO.class);
            oglasDTO.setPages(oglasi.getTotalPages());
            oglasDTOS.add(oglasDTO);
        }

        return new ResponseEntity<>(oglasDTOS, HttpStatus.OK);
    }

    public Sort sortBy(String sort){
        if(sort.equals("Price higher")){
            return Sort.by(Sort.Direction.ASC, "cjenovnik.cijenaPoDanu");
        }else if(sort.equals("Price lower")){
            return Sort.by(Sort.Direction.DESC, "cjenovnik.cijenaPoDanu");
        }else if(sort.equals("Kilometrage higher")){
            return Sort.by(Sort.Direction.ASC, "vozilo.kilometraza");
        }else if(sort.equals("Kilometrage lower")){
            return Sort.by(Sort.Direction.DESC, "vozilo.kilometraza");
        }else if(sort.equals("Grade higher")){
            return Sort.by(Sort.Direction.ASC, "vozilo.ocjena");
        }else if(sort.equals("Grade lower")){
            return Sort.by(Sort.Direction.DESC, "vozilo.ocjena");
        }
        return Sort.by(Sort.Direction.ASC, "od");
    }

    public ResponseEntity<?> getOneOglasById(Long id) {
        Oglas oglas = this.oglasRepository.getOne(id);
        OglasInfoDTO oglasDTO = new OglasInfoDTO();
        oglasDTO.setOd(oglas.getOd());
        oglasDTO.setDoo(oglas.getDoo());
        oglasDTO.setMjestoPreuzimanja(oglas.getMjestoPreuzimanja());
        oglasDTO.setCjenovnik(modelMapper.map(oglas.getCjenovnik(), CjenovnikDTO.class));
        oglasDTO.setDozvoljenaKilometraza(oglas.getDozvoljenaKilometraza());
        oglasDTO.setId(oglas.getId());

        VoziloInfoDTO voziloDTO = modelMapper.map(oglas.getVozilo(), VoziloInfoDTO.class);
        voziloDTO.setOcjena(oglas.getVozilo().getOcjena());

        oglasDTO.setVozilo(voziloDTO);

        return new ResponseEntity<>(oglasDTO, HttpStatus.OK);
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
