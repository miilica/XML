package com.service.impl;

import com.model.Ocena;
import com.repository.OcenaRepository;
import com.repository.VoziloRepository;
import com.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
