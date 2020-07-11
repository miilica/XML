package com.example.demo.dto;

import com.example.demo.model.Agent;
import com.example.demo.model.Zahtjev;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgentDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String adresa;
    private String imeKompanije;
    private String poslovniMB;
    private int brOglasa;
    private Set<VoziloDTO> vozila;
    private Set<Zahtjev> pristigliZahtjevi;

    public AgentDTO(Agent agent){
        this.id = agent.getId();
        this.ime = agent.getIme();
        this.prezime = agent.getPrezime();
        this.adresa = agent.getAdresa();
        this.imeKompanije = agent.getImeKompanije();
        this.poslovniMB = agent.getPoslovniMB();
        this.brOglasa = agent.getBrOglasa();
    }
}
