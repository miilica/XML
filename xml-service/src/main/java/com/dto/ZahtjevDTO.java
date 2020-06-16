package com.dto;

import com.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
    private Agent agent;

    //user koji je poslao zahtjev
    private User userPoslao;

    //user ciji je oglas
    private User userIzdao;

    private String zahtjevStatus;

    //iznajmljivanje pojedinacnih vozila
    private Vozilo vozilo;

    private Set<KorpaVozila> listaVozila;

    public ZahtjevDTO(Zahtjev zahtjev) {
        this.id = zahtjev.getId();
        this.datumKreiranja = zahtjev.getDatumKreiranja();
        this.potvrdjen = zahtjev.isPotvrdjen();
        this.bundle = zahtjev.isBundle();
        this.agent = zahtjev.getAgent();
        this.userPoslao = zahtjev.getUserPoslao();
        this.userIzdao = zahtjev.getUserIzdao();
        this.zahtjevStatus = zahtjev.getZahtjevStatus();
        this.vozilo = zahtjev.getVozilo();
        this.listaVozila = zahtjev.getKorpaVozila();
    }


}
