package com.example.xmlserviceoglas.dto;

import com.example.xmlserviceoglas.model.Agent;
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
    private String imeKompanije;
    private Set<VoziloDTO> vozila;
    private Set<ZahtjevDTO> pristigliZahtjevi;

    public AgentDTO(Agent agent){
        this.id = agent.getId();
        this.ime = agent.getIme();
        this.prezime = agent.getPrezime();
        this.imeKompanije = agent.getImeKompanije();
    }
}
