package com.service.impl;

import com.dto.OglasDTO;
import com.model.Oglas;
import com.model.User;
import com.model.Vozilo;
import com.repository.OglasRepository;
import com.service.OglasService;
import com.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class OglasServiceImpl implements OglasService {

    @Autowired
    private OglasRepository oglasRepository;

    @Autowired
    private VoziloService voziloService;

    @Override
    public Oglas findById(Long id) {
        return null;
    }

    public List<Oglas> findAll() throws AccessDeniedException {
        List<Oglas> result = oglasRepository.findAll();
        return result;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResponseEntity<Void> noviOglas(OglasDTO oglasDTO) {
        Vozilo vozilo = this.voziloService.findById(oglasDTO.getVozilo().getId());
        //PriceList priceList = this.priceListService.getPriceListById(adDTO.getPriceListId());
        //User user = vozilo.get(); vozilo nema vlasnika

        Oglas oglas = new Oglas();
        oglas.setVozilo(vozilo);
       oglas.setDostupan(oglasDTO.isDostupan());
        oglas.setFromDate(oglasDTO.getFromDate());
        oglas.setToDate(oglasDTO.getToDate());
        oglas.setMjestoPreuzimanja(oglasDTO.getMestoPreuzimanja());
        //oglas.setUser(adDTO.getToDate());
        //ad.setPriceList(priceList);


    /*    TAd tAd = createAdFromDTO(adDTO);
        try {
            PostAdResponse response = this.carClient.postNewCar(tAd);
            ad.setRefId(response.getAdResponse());
            log.info("Soap request successfully finished");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        this.oglasRepository.save(oglas);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
