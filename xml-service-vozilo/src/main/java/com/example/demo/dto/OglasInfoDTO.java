package com.example.demo.dto;

import com.example.demo.Util.JsonJodaDateTimeSerializer;
import com.example.demo.model.Oglas;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OglasInfoDTO {
    private Long id;
    private Integer pages;
    private String mjestoPreuzimanja;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime od;

    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    private DateTime doo;

    private double dozvoljenaKilometraza;
    private VoziloInfoDTO vozilo;
    private CjenovnikDTO cjenovnik;

    public OglasInfoDTO(Oglas o) {
        this.id = o.getId();
        this.mjestoPreuzimanja = o.getMjestoPreuzimanja();
        this.od = o.getOd();
        this.doo = o.getDoo();
        this.dozvoljenaKilometraza = o.getDozvoljenaKilometraza();
    }
}
