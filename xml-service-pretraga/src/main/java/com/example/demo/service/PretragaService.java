package com.example.demo.service;

import com.example.demo.dto.PretragaDTO;
import com.example.demo.model.Pretraga;

import java.lang.ref.PhantomReference;
import java.util.Date;

public interface PretragaService {

    Pretraga findById(Long id);
    Pretraga findAll();
    Pretraga save(PretragaDTO pretragaDTO);
    Pretraga delete(Long id);

    Pretraga findByOd(Date od);
    Pretraga findByDoo(Date doo);
    Pretraga findByModelVoyila(String model);
    Pretraga findByKilometraza(double kilometraza);
    Pretraga findByKlasaVozila(String klasa);
    Pretraga findByCijena(int cijena);
    Pretraga findByOcjena(double ocjena);
    Pretraga findByImeKompanije(String ime);
}
