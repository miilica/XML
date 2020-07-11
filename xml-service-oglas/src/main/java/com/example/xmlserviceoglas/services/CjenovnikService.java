package com.example.xmlserviceoglas.services;

import com.example.xmlserviceoglas.dto.CjenovnikDTO;
import com.example.xmlserviceoglas.model.Cjenovnik;
import com.example.xmlserviceoglas.model.User;
import com.example.xmlserviceoglas.repository.CjenovnikRepository;
import com.example.xmlserviceoglas.repository.UserRepository;
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
public class CjenovnikService {

    @Autowired
    private CjenovnikRepository cjenovnikRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<?> dodajCjenovnik(CjenovnikDTO cjenovnikDTO) {

        Cjenovnik cjenovnik = modelMapper.map(cjenovnikDTO, Cjenovnik.class);
        User user = this.userRepository.findByUsername(cjenovnikDTO.getUserUsername());
        cjenovnik.setUser(user);

        this.cjenovnikRepository.save(cjenovnik);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<?> izmjeniCjenovnik(CjenovnikDTO cjenovnikDTO) {

        Cjenovnik cjenovnik = this.cjenovnikRepository.getOne(cjenovnikDTO.getId());

        cjenovnik.setId(cjenovnikDTO.getId());
        cjenovnik.setCijenaPoDanu(cjenovnikDTO.getCijenaPoDanu());
        cjenovnik.setCijenaPoKM(cjenovnikDTO.getCijenaPoKM());
        cjenovnik.setCijenaCDW(cjenovnikDTO.getCijenaCDW());
        cjenovnik.setPopust(cjenovnikDTO.getPopust());

        this.cjenovnikRepository.save(cjenovnik);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getCjenovnik(String username) {

        List<Cjenovnik> cjenovnici = this.cjenovnikRepository.findAllByUserUsername(username);
        List<CjenovnikDTO> cjenovnikDTOS = new ArrayList<>();

        for(Cjenovnik c: cjenovnici){
            CjenovnikDTO cjenovnikDTO = modelMapper.map(c, CjenovnikDTO.class);
            cjenovnikDTO.setUserUsername(c.getUser().getUsername());

            cjenovnikDTOS.add(cjenovnikDTO);
        }


        return new ResponseEntity<>(cjenovnikDTOS, HttpStatus.OK);
    }
}
