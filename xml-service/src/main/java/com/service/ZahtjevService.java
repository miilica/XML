package com.service;

import com.dto.VoziloDTO;
import com.dto.ZahtjevDTO;
import com.model.Vozilo;
import com.model.Zahtjev;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZahtjevService {

    List<ZahtjevDTO> findAllVehiclesToRateComment();

    Zahtjev findById(Long id);

    void vehicleToReserved(Zahtjev zahtjev);
    void vehicleToReservedBundle(Zahtjev zahtjev);

    void vehicleToCanceled(Zahtjev zahtjev);

    void payForRentACar(Zahtjev zahtjev);

    ZahtjevDTO findByIds(Long vehicleId, Long agentId);

    Vozilo rateVehicle(VoziloDTO voziloDTO, Double rate);
    Vozilo commentVehicle(VoziloDTO voziloDTO, String komentar);

    ResponseEntity<?> findAllZahtjeve();

    ResponseEntity<?> findAllZahtjeveUserProsli();
}
