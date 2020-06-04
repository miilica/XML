package com.service.impl;

import com.dto.VoziloDTO;
import com.model.KorpaVozila;
import com.model.Oglas;
import com.model.Vozilo;
import com.repository.KorpaVozilaRepository;
import com.repository.VoziloRepository;
import com.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;

    @Override
    public List<Vozilo> findAll() {
        List<Vozilo> result = voziloRepository.findAll();
        return result;
    }

}
