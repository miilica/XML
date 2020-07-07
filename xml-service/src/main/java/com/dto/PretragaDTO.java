package com.dto;

import com.Util.JsonJodaDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.model.KlasaAutomobila;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
@NoArgsConstructor
public class PretragaDTO {
    private String mjestoPreuzimanja;
    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime od;
    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime doo;
    private MarkaAutomobilaDTO marka;
    private VrstaGorivaDTO gorivo;
    private TipMjenjacaDTO mjenjac;
    private KlasaAutomobilaDTO klasa;
    private double cijenaOd;
    private double cijenaDo;
    private double kilometrazaOd;
    private double kilometrazaDo;
    private double kilometrazaDozvoljena;
    private Boolean cdw;
    private int brojDjecijihMjesta;
}
