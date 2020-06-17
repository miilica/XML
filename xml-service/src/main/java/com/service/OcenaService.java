package com.service;

import com.model.Ocena;

import java.util.List;

public interface OcenaService {

    List<Ocena> findAllByVehicleId(Long vehicleId);
}
