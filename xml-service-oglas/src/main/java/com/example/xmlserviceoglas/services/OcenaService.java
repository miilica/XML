package com.example.xmlserviceoglas.services;

import com.example.xmlserviceoglas.dto.OcenaDTO;
import com.example.xmlserviceoglas.model.Ocena;
import com.example.xmlserviceoglas.model.Oglas;
import com.example.xmlserviceoglas.model.User;
import com.example.xmlserviceoglas.model.Vozilo;
import com.example.xmlserviceoglas.repository.OcenaRepository;
import com.example.xmlserviceoglas.repository.OglasRepository;
import com.example.xmlserviceoglas.repository.UserRepository;
import com.example.xmlserviceoglas.repository.VoziloRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OcenaService{

    @Autowired
    private OcenaRepository ocenaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OglasRepository oglasRepository;

    @Autowired
    private VoziloRepository voziloRepository;

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
        User user = this.userRepository.findByUsername(ocenaDTO.getUserUsername());
        ocena.setUserId(user.getId());
        Oglas oglas = this.oglasRepository.findById(ocenaDTO.getOglasId()).orElseGet(null);
        ocena.setOglas(oglas);
        ocena.setVozilo(oglas.getVozilo());
        Vozilo vozilo = oglas.getVozilo();
        double sum = 0;
        if(vozilo.getOcjene().size() != 0) {
            for (Ocena o : vozilo.getOcjene()) {
                sum = sum + o.getOcena();
            }
            vozilo.setOcjena(sum/vozilo.getOcjene().size());
        }

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
            User user = this.userRepository.findById(o.getUserId()).orElseGet(null);
            ocenaDTO.setUserUsername(user.getUsername());
            ocenaDTOS.add(ocenaDTO);
        }

        return new ResponseEntity<>(ocenaDTOS, HttpStatus.OK);
    }
}
