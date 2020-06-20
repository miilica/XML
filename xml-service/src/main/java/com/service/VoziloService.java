package com.service;

import com.dto.VoziloDTO;
import com.model.TerminIznajmljivanja;
import com.model.Vozilo;

import java.util.List;

public interface VoziloService {
    List<Vozilo> findAll();

    List<TerminIznajmljivanja> findAllTermineIznajmljivanja();

    Vozilo addKmToVehicle(VoziloDTO voziloDTO, Double rate);
}
