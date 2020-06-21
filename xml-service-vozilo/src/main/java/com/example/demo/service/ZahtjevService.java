package com.example.demo.service;

import com.example.demo.dto.VoziloDTO;
import com.example.demo.model.Vozilo;
import com.example.demo.model.Zahtjev;

import java.util.List;

public interface ZahtjevService {

    List<Zahtjev> findAll();
    List<Zahtjev> findAllVehiclesToRateComment();

    Zahtjev findById(Long id);

    void vehicleToReserved(Zahtjev zahtjev);
    void vehicleToReservedBundle(Zahtjev zahtjev);

    void vehicleToCanceled(Zahtjev zahtjev);

    void payForRentACar(Zahtjev zahtjev);

    Zahtjev findByIds(Long vehicleId, Long agentId);

    Vozilo rateVehicle(VoziloDTO voziloDTO, Double rate);
    Vozilo commentVehicle(VoziloDTO voziloDTO, String komentar);
}
