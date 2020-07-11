package com.example.xmlserviceoglas.dto;

import com.example.xmlserviceoglas.Util.JsonJodaDateTimeSerializer;
import com.example.xmlserviceoglas.model.Oglas;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OglasInfoDTO {

    private Long id;
    private String mjestoPreuzimanja;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime od;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime doo;

    private double dozvoljenaKilometraza;
    private VoziloDTO vozilo;
    private CjenovnikDTO cjenovnik;

    public OglasInfoDTO(Oglas o) {
        this.id = o.getId();
        this.mjestoPreuzimanja = o.getMjestoPreuzimanja();
        this.od = o.getOd();
        this.doo = o.getDoo();
        this.dozvoljenaKilometraza = o.getDozvoljenaKilometraza();
    }
}
