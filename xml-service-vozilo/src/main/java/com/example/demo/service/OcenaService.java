package com.example.demo.service;

import com.example.demo.model.Ocena;

import java.util.List;

public interface OcenaService {

    List<Ocena> findAllByVehicleId(Long vehicleId);
}
