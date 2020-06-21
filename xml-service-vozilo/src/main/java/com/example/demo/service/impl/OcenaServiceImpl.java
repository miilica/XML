package com.example.demo.service.impl;

import com.example.demo.model.Ocena;
import com.example.demo.repository.OcenaRepository;
import com.example.demo.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OcenaServiceImpl implements OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;

    @Override
    public List<Ocena> findAllByVehicleId(Long vehicleId) {
        List<Ocena> listaOcena = ocenaRepository.findAll();
        List<Ocena> result = new ArrayList<>();

        for(Ocena o: listaOcena) {
            if(o.getVozilo().getId() == vehicleId) {
                result.add(o);
            }
        }

        return result;
    }
}
