package com.service.impl;

import com.dto.OglasDTO;
import com.model.Oglas;
import com.repository.OglasRepository;
import com.service.OglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class OglasServiceImpl implements OglasService {

    @Autowired
    private OglasRepository oglasRepository;

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
        Oglas oglas = this.findById(id);
        oglas.setObrisan(true);
        this.oglasRepository.save(oglas);
    }

    public Oglas edit(OglasDTO oglasDTO){
        Oglas oglas = this.findById(oglasDTO.getId());
        oglas.setId(oglasDTO.getId());
        oglas.setMjestoPreuzimanja(oglasDTO.getMestoPreuzimanja());
        oglas.setVozilo(oglasDTO.getVozilo());
        oglas.setDostupan(oglasDTO.isDostupan());
        this.oglasRepository.save(oglas);
        return oglas;
    }


}
