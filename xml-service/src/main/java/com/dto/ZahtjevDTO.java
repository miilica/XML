package com.dto;

import com.Util.JsonJodaDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
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
    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime Doo;
    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime Od;
    private OglasInfoDTO oglas;
    private String zahtjevStatus;
    //iznajmljivanje pojedinacnih vozila
    private VoziloDTO vozilo;

    private Set<KorpaVozilaDTO> listaVozila;

    public ZahtjevDTO(Zahtjev zahtjev) {
        this.id = zahtjev.getId();
        this.Od = zahtjev.getOd();
        this.Doo = zahtjev.getDoo();
        this.datumKreiranja = zahtjev.getDatumKreiranja();
        this.potvrdjen = zahtjev.isPotvrdjen();
        this.bundle = zahtjev.isBundle();
        this.agent = new AgentDTO(zahtjev.getAgent());
        this.userPoslao = new UserDTO(zahtjev.getUserPoslao());
        this.userIzdao = new UserDTO(zahtjev.getUserIzdao());
        this.zahtjevStatus = zahtjev.getZahtjevStatus();
        this.vozilo = new VoziloDTO(zahtjev.getVozilo());
        this.oglas = new OglasInfoDTO(zahtjev.getOglas());
    }
}
