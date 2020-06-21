package com.example.demo.service;


import com.example.demo.dto.KorpaVozilaDTO;
import com.example.demo.model.KorpaVozila;
import com.example.demo.model.Zahtjev;

import java.util.List;

public interface KorpaVozilaService {

    KorpaVozila addVehicleToCart(KorpaVozilaDTO vozilo);

    List<KorpaVozila> findAll();

    Zahtjev rentACarRequest(KorpaVozilaDTO vozilo);

    Zahtjev rentACarRequestBundle(KorpaVozilaDTO[] listaVozila);
}
