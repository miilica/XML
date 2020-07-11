package com.example.xmlserviceoglas.services;

import com.example.xmlserviceoglas.configuration.consts.ZahtjevStatus;
import com.example.xmlserviceoglas.dto.KorpaVozilaDTO;
import com.example.xmlserviceoglas.model.*;
import com.example.xmlserviceoglas.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KorpaVozilaService{

    @Autowired
    private KorpaVozilaRepository korpaVozilaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VoziloRepository voziloRepository;

    @Autowired
    private OglasRepository oglasRepository;

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
        Vozilo vozilo1 = voziloRepository.getOne(vozilo.getId());
        v.setAgent(vozilo1.getAgent());
        v.setBrSjedistaZaDjecu(vozilo.getBrSjedistaZaDjecu());
        v.setColiisionDamageWavier(vozilo.isColiisionDamageWavier());
        v.setImaAndroid(vozilo.getImaAndroid());

        korpaVozilaRepository.save(v);

        return v;
    }

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

    public Zahtjev rentACarRequest(KorpaVozilaDTO vozilo) {
        Date currentUtilDate = new Date();
        Zahtjev zahtjev = new Zahtjev();
        zahtjev.setDatumKreiranja(currentUtilDate);
        zahtjev.setPotvrdjen(false);
        Vozilo vozilo1 = voziloRepository.getOne(vozilo.getId());
        zahtjev.setAgent(vozilo1.getAgent());
        zahtjev.setBundle(vozilo.isBundle());
        zahtjev.setOglas(this.oglasRepository.getOne(1L));
        zahtjev.setZahtjevStatus(ZahtjevStatus.STATUS_PENDING);

        Vozilo vozilo2 = voziloRepository.getOne(vozilo.getVehicleId());
        zahtjev.setVozilo(vozilo2);

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
            Vozilo vozilo1 = voziloRepository.getOne(vozilo.getId());
            v.setAgent(vozilo1.getAgent());
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
            zahtjev.setKorpaVozilaDTOS(listaVozilaPomocna);
        } else {
            zahtjev.setKorpaVozilaDTOS(null);
        }

        zahtjev.setDatumKreiranja(currentUtilDate);
        zahtjev.setPotvrdjen(false);
        zahtjev.setBundle(true);
        zahtjev.setAgent(modelMapper.map(listaVozila[0].getAgent(), Agent.class));
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
