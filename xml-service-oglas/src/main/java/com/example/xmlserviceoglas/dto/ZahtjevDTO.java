package com.example.xmlserviceoglas.dto;

import com.example.xmlserviceoglas.Util.JsonJodaDateTimeSerializer;
import com.example.xmlserviceoglas.model.Zahtjev;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZahtjevDTO {

    private Long id;
    private Date datumKreiranja;
    private boolean potvrdjen;
    private  boolean bundle;
    private String zahtjevStatus;
    private AgentDTO agent;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime Doo;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime Od;


    public ZahtjevDTO(Zahtjev zahtjev) {
        this.id = zahtjev.getId();
        this.Od = zahtjev.getOd();
        this.Doo = zahtjev.getDoo();
        this.datumKreiranja = zahtjev.getDatumKreiranja();
        this.potvrdjen = zahtjev.isPotvrdjen();
        this.bundle = zahtjev.isBundle();
        this.zahtjevStatus = zahtjev.getZahtjevStatus();
        this.agent = new AgentDTO(zahtjev.getAgent());
    }
}
