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

    }

}
