package com.example.demo.service;

import com.example.demo.dto.VoziloDTO;
import com.example.demo.model.Vozilo;

import java.util.List;

public interface VoziloService {

    Vozilo findById(Long id);
    List<Vozilo> findAll();
    Vozilo save(VoziloDTO voziloDTO);
    Vozilo delete(VoziloDTO voziloDTO);

}
