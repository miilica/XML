package com.service.impl;

import com.dto.OcenaDTO;
import com.model.Ocena;
import com.model.Oglas;
import com.model.User;
import com.model.Vozilo;
import com.repository.OcenaRepository;
import com.repository.VoziloRepository;
import com.service.OcenaService;
import com.service.OglasService;
import com.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OcenaServiceImpl implements OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private OglasService oglasService;

    @Autowired
    private VoziloRepository voziloRepository;

    @Override
    public List<Ocena> findAllByVehicleId(Long vehicleId) {
        List<Ocena> listaOcena = ocenaRepository.findAll();
        List<Ocena> result = new ArrayList<>();

        for(Ocena o: listaOcena) {
            if(o.getVozilo().getId() == vehicleId) {
                result.add(o);
            }
        }

        return result;
    }

    public ResponseEntity<?> kreirajOcjenu(OcenaDTO ocenaDTO) {
        Ocena ocena = modelMapper.map(ocenaDTO, Ocena.class);
        User user = this.userService.findByUsername(ocenaDTO.getUserUsername());
        ocena.setUserId(user.getId());
        Oglas oglas = this.oglasService.findById(ocenaDTO.getOglasId());
        ocena.setOglas(oglas);
        ocena.setVozilo(oglas.getVozilo());
        Vozilo vozilo = oglas.getVozilo();
        double sum = 0;
        for(Ocena o: vozilo.getOcjene()){
            sum = sum + o.getOcena();
        }
        vozilo.setOcjena(sum/vozilo.getOcjene().size());
        this.voziloRepository.save(vozilo);
        this.ocenaRepository.save(ocena);

        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<?> getOcjeneZaAuto(Long voziloId) {
        List<Ocena> ocenas = this.ocenaRepository.findAllByVoziloId(voziloId);
        List<OcenaDTO> ocenaDTOS = new ArrayList<>();

        for(Ocena o: ocenas){
            OcenaDTO ocenaDTO = modelMapper.map(o, OcenaDTO.class);
            ocenaDTO.setVoziloId(o.getVozilo().getId());
            ocenaDTO.setOglasId(o.getOglas().getId());
            User user = this.userService.findById(o.getUserId());
            ocenaDTO.setUserUsername(user.getUsername());
            ocenaDTOS.add(ocenaDTO);
        }

        return new ResponseEntity<>(ocenaDTOS, HttpStatus.OK);
    }
}
