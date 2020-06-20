package com.service;

import com.dto.KorpaVozilaDTO;
import com.dto.VoziloDTO;
import com.model.KorpaVozila;
import com.model.Vozilo;
import com.model.Zahtjev;

import java.util.List;

public interface KorpaVozilaService {

    KorpaVozila addVehicleToCart(KorpaVozilaDTO vozilo);

    List<KorpaVozila> findAll();

    Zahtjev rentACarRequest(KorpaVozilaDTO vozilo);

    Zahtjev rentACarRequestBundle(KorpaVozilaDTO[] listaVozila);
}
