package com.service;

import com.model.Zahtjev;

import java.util.List;

public interface ZahtjevService {

    List<Zahtjev> findAll();

    Zahtjev findById(Long id);

    void vehicleToReserved(Zahtjev zahtjev);

    void vehicleToCanceled(Zahtjev zahtjev);

    void payForRentACar(Zahtjev zahtjev);

    Zahtjev findByIds(Long vehicleId, Long agentId);
}
