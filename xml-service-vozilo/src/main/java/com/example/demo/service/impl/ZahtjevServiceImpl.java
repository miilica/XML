package com.example.demo.service.impl;

import com.example.demo.config.consts.ZahtjevStatus;
import com.example.demo.dto.VoziloDTO;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.OcenaService;
import com.example.demo.service.VoziloService;
import com.example.demo.service.ZahtjevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private ZahtjevService zahtjevService;

    @Autowired
    private VoziloService voziloService;

    @Autowired
    private OcenaRepository ocenaRepository;

    @Autowired
    private OcenaService ocenaService;

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
                        for (KorpaVozila korpaVozila1 : zahtjev.getKorpaVozila()) {
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
                            for (KorpaVozila korpaVozila1 : zahtjev.getKorpaVozila()) {
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

    @Override
    public List<Zahtjev> findAllVehiclesToRateComment() {
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
            if(zahtjev.getUserPoslao().getId() == u.getId() && zahtjev.getZahtjevStatus().equals(ZahtjevStatus.STATUS_PAID)) { // TODO: dodati uslov nakon isteka vremna
                result.add(zahtjev);
            }
        }

        return result;
    }

    @Override
    public Vozilo rateVehicle(VoziloDTO voziloDTO, Double rate){
        Vozilo vozilo = voziloRepository.findById(voziloDTO.getId()).orElseGet(null);

        Ocena ocena = new Ocena();
        Set<Ocena> listaOcena = new HashSet<>();
        ocena.setOcena(rate);
        ocena.setUserId(voziloDTO.getId());
        ocena.setVozilo(new Vozilo(voziloDTO));
        listaOcena.add(ocena);

        Double prosecnaOcena = 0.0;
        List<Ocena> listaOcena1 = ocenaService.findAllByVehicleId(voziloDTO.getId());
        int ukupno = listaOcena1.size();
        if(listaOcena1.isEmpty()) {
            prosecnaOcena = rate;
        }
        for(Ocena o: listaOcena1) {
            prosecnaOcena += o.getOcena();
        }
        if(ukupno != 0)
            prosecnaOcena = prosecnaOcena/ukupno;
        else
            prosecnaOcena = rate;

        vozilo.setOcjene(listaOcena);
        vozilo.setOcjena(prosecnaOcena);

        vozilo = voziloRepository.save(vozilo);

        return vozilo;
    }

    @Override
    public Vozilo commentVehicle(VoziloDTO voziloDTO, String comment){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object currentUser = auth.getPrincipal();

        String username = "";
        if (currentUser instanceof UserDetails) {
            username = ((UserDetails)currentUser).getUsername();
        } else {
            username = currentUser.toString();
        }

        User u = userRepository.findByUsername(username);

        Vozilo vozilo = voziloRepository.findById(voziloDTO.getId()).orElseGet(null);

        Set<Komentar> komentari = new HashSet<>();
        Komentar kom = new Komentar();
        kom.setOdobren(false);
        kom.setTekst(comment);
        kom.setVozilo(new Vozilo(voziloDTO));
        kom.setUserId(u.getId());
        komentari.add(kom);
        vozilo.setKomentari(komentari);

        vozilo = voziloRepository.save(vozilo);

        return vozilo;
    }

}