package com.dto;

import com.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZahtjevDTO {

    @Autowired
    private ModelMapper modelMapper;

    private Long id;

    private Date datumKreiranja;

    private boolean potvrdjen;

    private  boolean bundle;

    //agent ciji je oglas
    private AgentDTO agent;

    //user koji je poslao zahtjev
    private UserDTO userPoslao;

    //user ciji je oglas
    private UserDTO userIzdao;

    private String zahtjevStatus;

    //iznajmljivanje pojedinacnih vozila
    private VoziloDTO vozilo;

    private Set<KorpaVozilaDTO> listaVozila;

    public ZahtjevDTO(Zahtjev zahtjev) {
        this.id = zahtjev.getId();
        this.datumKreiranja = zahtjev.getDatumKreiranja();
        this.potvrdjen = zahtjev.isPotvrdjen();
        this.bundle = zahtjev.isBundle();
        this.agent = modelMapper.map(zahtjev.getAgent(), AgentDTO.class);
        this.userPoslao = modelMapper.map(zahtjev.getUserPoslao(), UserDTO.class);
        this.userIzdao = modelMapper.map(zahtjev.getUserIzdao(), UserDTO.class);
        this.zahtjevStatus = zahtjev.getZahtjevStatus();
        this.vozilo = modelMapper.map(zahtjev.getVozilo(), VoziloDTO.class);
        Set<KorpaVozilaDTO> k = new HashSet<>();
        for(KorpaVozila kv: zahtjev.getKorpaVozila()){
            k.add(modelMapper.map(kv, KorpaVozilaDTO.class));
        }

        this.listaVozila = k;
    }
}
