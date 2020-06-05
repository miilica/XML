package com.service.impl;

import com.dto.KorpaVozilaDTO;
import com.exception.ApiRequestException;
import com.model.KorpaVozila;
import com.model.User;
import com.model.Zahtjev;
import com.repository.KorpaVozilaRepository;
import com.repository.UserRepository;
import com.repository.ZahtjevRepository;
import com.service.KorpaVozilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class KorpaVozilaServiceImpl implements KorpaVozilaService {

    @Autowired
    private KorpaVozilaRepository korpaVozilaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @Override
    public KorpaVozila addVehicleToCart(KorpaVozilaDTO vozilo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object currentUser = auth.getPrincipal();

        String username = "";
        if (currentUser instanceof UserDetails) {
            username = ((UserDetails)currentUser).getUsername();
        } else {
            username = currentUser.toString();
        }

        User u = userRepository.findByUsername(username);

        KorpaVozila v = new KorpaVozila();
        v.setCijena(vozilo.getCijena());
        v.setKilometraza(vozilo.getKilometraza());
        v.setMozePreciKM(vozilo.getMozePreciKM());
        v.setUserId(u.getId());
        v.setVehicleId(vozilo.getId());
        v.setOcjena(vozilo.getOcjena());
        v.setAgent(vozilo.getAgent());
        v.setBrSjedistaZaDjecu(vozilo.getBrSjedistaZaDjecu());
        v.setColiisionDamageWavier(vozilo.isColiisionDamageWavier());
        v.setImaAndroid(vozilo.getImaAndroid());

        korpaVozilaRepository.save(v);

        return v;
    }

    @Override
    public List<KorpaVozila> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object currentUser = auth.getPrincipal();

        String username = "";
        if (currentUser instanceof UserDetails) {
            username = ((UserDetails)currentUser).getUsername();
        } else {
            username = currentUser.toString();
        }

        User u = userRepository.findByUsername(username);

        List<KorpaVozila> all = korpaVozilaRepository.findAll();
        List<KorpaVozila> result = new ArrayList<>();

        for(KorpaVozila kv : all) {
            if(kv.getUserId() == u.getId()) {
                result.add(kv);
            }
        }

        return result;
    }

    @Override
    public Zahtjev rentACarRequest(KorpaVozilaDTO vozilo) {
        Date currentUtilDate = new Date();
        Zahtjev zahtjev = new Zahtjev();
        zahtjev.setDatumKreiranja(currentUtilDate);
        zahtjev.setPotvrdjen(false);
        zahtjev.setAgent(vozilo.getAgent());
        zahtjev.setBundle(vozilo.isBundle());

        zahtjevRepository.save(zahtjev);

        return zahtjev;
    }

}
