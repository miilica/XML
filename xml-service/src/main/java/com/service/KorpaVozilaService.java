package com.service;

import com.dto.KorpaVozilaDTO;
import com.dto.VoziloDTO;
import com.model.KorpaVozila;
import com.model.Vozilo;

import java.util.List;

public interface KorpaVozilaService {
    KorpaVozila addVehicleToCart(KorpaVozilaDTO vozilo);
    List<KorpaVozila> findAll();
}
