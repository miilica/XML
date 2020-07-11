package com.service.impl;

import com.dto.ZauzeceDTO;
import com.model.Oglas;
import com.model.Vozilo;
import com.model.Zahtjev;
import com.model.Zauzece;
import com.repository.ZahtjevRepository;
import com.repository.ZauzeceRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ZauzeceService {

    @Autowired
    private ZauzeceRepository zauzeceRepository;

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @Autowired
    private VoziloServiceImpl voziloService;

    public ResponseEntity<?> getZauzece(Long id) {
        Zauzece zauzece = zauzeceRepository.getOne(id);
        ZauzeceDTO zauzeceDTO = new ZauzeceDTO();

        zauzeceDTO.setId(zauzece.getId());
        zauzeceDTO.setZauzetOd(zauzece.getZauzetOd());
        zauzeceDTO.setZauzetDo(zauzece.getZauzetDo());
        zauzeceDTO.setVoziloId(zauzece.getVozilo().getId());

        return new ResponseEntity<>(zauzeceDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> zauzeceAutomobila(ZauzeceDTO zauzeceDTO) {

        Zauzece zauzece = new Zauzece();
        zauzece.setZauzetOd(zauzeceDTO.getZauzetOd());
        zauzece.setZauzetDo(zauzeceDTO.getZauzetDo());

        Vozilo vozilo = voziloService.getVozilo(zauzeceDTO.getVoziloId());
        zauzece.setVozilo(vozilo);

        List<Long> oglasi = new ArrayList<>();

        for(Oglas o: vozilo.getOglasi()){
            oglasi.add(o.getId());
        }

        zauzeceDTO.setOglasId(oglasi);

        DateTime zauzetOd = zauzece.getZauzetOd();
        DateTime zauzetDo = zauzece.getZauzetDo();

        for(Long id: zauzeceDTO.getOglasId()){
            List<Zahtjev> zahtjevi = this.zahtjevRepository.findByOglasId(id);

            for(Zahtjev z: zahtjevi) {
                DateTime zahtjevOd = z.getOd();
                DateTime zahtjevDo = z.getDoo();

                if (z.getZahtjevStatus().equals("STATUS_PENDING")) {
                    if (zahtjevOd.isAfter(zauzetOd) && zahtjevDo.isBefore(zauzetDo)) {
                        z.setZahtjevStatus("STATUS_CANCELED");
                        this.zahtjevRepository.save(z);
                    }

                    if (zahtjevOd.isBefore(zauzetOd) && zahtjevDo.isAfter(zauzetDo)) {
                        z.setZahtjevStatus("STATUS_CANCELED");
                        this.zahtjevRepository.save(z);
                    }
                    if (zahtjevOd.isBefore(zauzetOd) && zahtjevDo.isBefore(zauzetDo) && zahtjevOd.isAfter(zauzetOd)) {
                        z.setZahtjevStatus("STATUS_CANCELED");
                        this.zahtjevRepository.save(z);
                    }
                    if (zahtjevOd.isAfter(zauzetOd) && zahtjevDo.isAfter(zauzetDo) && zahtjevDo.isBefore(zauzetDo)) {
                        z.setZahtjevStatus("STATUS_CANCELED");
                        this.zahtjevRepository.save(z);
                    }
                }
            }
        }

        this.zauzeceRepository.save(zauzece);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
