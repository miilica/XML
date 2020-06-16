package com.service.impl;

import com.config.consts.ZahtjevStatus;
import com.model.*;
import com.repository.KorpaVozilaRepository;
import com.repository.UserRepository;
import com.repository.VoziloRepository;
import com.repository.ZahtjevRepository;
import com.service.ZahtjevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZahtjevServiceImpl implements ZahtjevService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ZahtjevRepository zahtjevRepository;

    @Autowired
    private VoziloRepository voziloRepository;

    @Autowired
    private KorpaVozilaRepository korpaVozilaRepository;

    @Override
    public List<Zahtjev> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object currentUser = auth.getPrincipal();

        String username = "";
        if (currentUser instanceof UserDetails) {
            username = ((UserDetails)currentUser).getUsername();
        } else {
            username = currentUser.toString();
        }

        User u = userRepository.findByUsername(username);

        List<Zahtjev> all = zahtjevRepository.findAll();
        List<Zahtjev> result = new ArrayList<>();

        for(Zahtjev zahtjev : all) {
            if(zahtjev.getAgent().getId() == u.getId()) {
                result.add(zahtjev);
            }
        }

        return result;
    }

    //obican zahtev
    @Override
    public void vehicleToReserved(Zahtjev zahtjev){
        List<Zahtjev> listaZahtjeva = zahtjevRepository.findAll();
        boolean vecRezervisan = false;

        for(Zahtjev z: listaZahtjeva) {
            if(!z.isBundle()) {
                if (z.getZahtjevStatus().equals(ZahtjevStatus.STATUS_RESERVED) && z.getAgent().getId() == zahtjev.getAgent().getId() && z.getVozilo().getId() == zahtjev.getVozilo().getId()) {
                    vecRezervisan = true;
                }
            }
        }

        if(vecRezervisan == false ) {
            for(Zahtjev z: listaZahtjeva) {
                if(!z.isBundle()) {
                    if (z.getAgent().getId() == zahtjev.getAgent().getId() && z.getVozilo().getId() == zahtjev.getVozilo().getId()) {
                        if (zahtjev.getZahtjevStatus().equals(ZahtjevStatus.STATUS_PENDING)) {
                            zahtjev.setZahtjevStatus(ZahtjevStatus.STATUS_RESERVED);
                            zahtjev.setPotvrdjen(true);
                            zahtjevRepository.save(zahtjev);
                        }
                    }
                }
            }
        }
    }

    //bundle zahtev
    @Override
    public void vehicleToReservedBundle(Zahtjev zahtjev){
        List<Zahtjev> listaZahtjeva = zahtjevRepository.findAll();
        List<KorpaVozila> listaZahtjevaKorpa = korpaVozilaRepository.findAll();
        boolean vecRezervisan = false;
        boolean sacuvan = false;

        for(Zahtjev z: listaZahtjeva) {
            if(z.isBundle()) {
                if (z.getZahtjevStatus().equals(ZahtjevStatus.STATUS_RESERVED) && z.getAgent().getId() == zahtjev.getAgent().getId()) {
                    for (KorpaVozila korpaVozila : z.getKorpaVozila()) {
                        for (KorpaVozila korpaVozila1 : listaZahtjevaKorpa) {
                            if (korpaVozila.getVehicleId() == korpaVozila1.getVehicleId()) {
                                vecRezervisan = true;
                            }
                        }
                    }
                }
            }
        }

        if(vecRezervisan == false ) {
            for(Zahtjev z: listaZahtjeva) {
                if(z.isBundle()) {
                    if (z.getAgent().getId() == zahtjev.getAgent().getId()) {
                        for (KorpaVozila korpaVozila : z.getKorpaVozila()) {
                            for (KorpaVozila korpaVozila1 : listaZahtjevaKorpa) {
                                if(korpaVozila.getVehicleId() == korpaVozila1.getVehicleId()) {
                                    if (zahtjev.getZahtjevStatus().equals(ZahtjevStatus.STATUS_PENDING)) {
                                        zahtjev.setZahtjevStatus(ZahtjevStatus.STATUS_RESERVED);
                                        zahtjev.setPotvrdjen(true);
                                        zahtjevRepository.save(zahtjev);
                                        sacuvan = true;
                                        break;
                                    }
                                }
                            }
                            if(sacuvan) {
                                break;
                            }
                        }
                    }
                }
                if(sacuvan) {
                    break;
                }
            }
        }
    }

    @Override
    public void vehicleToCanceled(Zahtjev zahtjev) {
        zahtjev.setZahtjevStatus(ZahtjevStatus.STATUS_CANCELED);
        zahtjev.setPotvrdjen(false);
        zahtjevRepository.save(zahtjev);
    }

    public Zahtjev findById(Long id) throws AccessDeniedException {
        Zahtjev z = zahtjevRepository.findById(id).orElseGet(null);
        return z;
    }

    @Override
    public Zahtjev findByIds(Long voziloId, Long agentId) throws AccessDeniedException {
        List<Zahtjev> listaZahtjeva = zahtjevRepository.findAll();
        for(Zahtjev z: listaZahtjeva) {
            if(!z.isBundle()) {
                if (z.getVozilo().getId() == voziloId && z.getVozilo().getAgent().getId() == agentId) {
                    z = zahtjevRepository.findById(z.getId()).orElseGet(null);
                    return z;
                }
            } else {
                for(KorpaVozila kv: z.getKorpaVozila()) {
                    if(kv.getVehicleId() == voziloId && kv.getAgent().getId() == agentId) {
                        z = zahtjevRepository.findById(z.getId()).orElseGet(null);
                        return z;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void payForRentACar(Zahtjev zahtjev){
        if(zahtjev.getZahtjevStatus().equals(ZahtjevStatus.STATUS_RESERVED)) {
            zahtjev.setZahtjevStatus(ZahtjevStatus.STATUS_PAID);
            zahtjevRepository.save(zahtjev);
        }
    }

}
