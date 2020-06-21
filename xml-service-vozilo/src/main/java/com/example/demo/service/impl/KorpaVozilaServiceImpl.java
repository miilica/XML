package com.example.demo.service.impl;

import com.example.demo.config.consts.ZahtjevStatus;
import com.example.demo.dto.KorpaVozilaDTO;
import com.example.demo.model.KorpaVozila;
import com.example.demo.model.User;
import com.example.demo.model.Vozilo;
import com.example.demo.model.Zahtjev;
import com.example.demo.repository.KorpaVozilaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ZahtjevRepository;
import com.example.demo.service.KorpaVozilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KorpaVozilaServiceImpl implements KorpaVozilaService {

    @Autowired
    private KorpaVozilaRepository korpaVozilaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @Autowired
    private VoziloServiceImpl voziloService;

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
        zahtjev.setZahtjevStatus(ZahtjevStatus.STATUS_PENDING);

        Vozilo vozilo1 = voziloService.findById(vozilo.getVehicleId());
        zahtjev.setVozilo(vozilo1);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object currentUser = auth.getPrincipal();

        String username = "";
        if (currentUser instanceof UserDetails) {
            username = ((UserDetails)currentUser).getUsername();
        } else {
            username = currentUser.toString();
        }
        User u = userRepository.findByUsername(username);
        zahtjev.setUserPoslao(u);

        zahtjevRepository.save(zahtjev);

        return zahtjev;
    }

    public Zahtjev rentACarRequestBundle(KorpaVozilaDTO[] listaVozila) {
        Date currentUtilDate = new Date();
        Zahtjev zahtjev = new Zahtjev();
        Set<KorpaVozila> listaVozilaPomocna = new HashSet<>();

        for(KorpaVozilaDTO vozilo: listaVozila) {
            KorpaVozila v = new KorpaVozila();
            v.setKilometraza(vozilo.getKilometraza());
            v.setAgent(vozilo.getAgent());
            v.setVehicleId(vozilo.getVehicleId());
            v.setImaAndroid(vozilo.getImaAndroid());

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object currentUser = auth.getPrincipal();

            String username = "";
            if (currentUser instanceof UserDetails) {
                username = ((UserDetails)currentUser).getUsername();
            } else {
                username = currentUser.toString();
            }
            User u = userRepository.findByUsername(username);

            v.setUserId(u.getId());

            v.setOcjena(vozilo.getOcjena());
            v.setMozePreciKM(vozilo.getMozePreciKM());
            v.setCijena(vozilo.getCijena());
            v.setBundle(vozilo.isBundle());
            v.setColiisionDamageWavier(vozilo.isColiisionDamageWavier());
            v.setBrSjedistaZaDjecu(vozilo.getBrSjedistaZaDjecu());

            listaVozilaPomocna.add(v);
        }

        if(listaVozila != null) {
            zahtjev.setKorpaVozila(listaVozilaPomocna);
        } else {
            zahtjev.setKorpaVozila(null);
        }

        zahtjev.setDatumKreiranja(currentUtilDate);
        zahtjev.setPotvrdjen(false);
        zahtjev.setBundle(true);
        zahtjev.setAgent(listaVozila[0].getAgent());
        zahtjev.setZahtjevStatus(ZahtjevStatus.STATUS_PENDING);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object currentUser = auth.getPrincipal();

        String username = "";
        if (currentUser instanceof UserDetails) {
            username = ((UserDetails)currentUser).getUsername();
        } else {
            username = currentUser.toString();
        }
        User u = userRepository.findByUsername(username);
        zahtjev.setUserPoslao(u);

        zahtjevRepository.save(zahtjev);


        return zahtjev;
    }

}
