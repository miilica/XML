package com.dto;

import com.Util.JsonJodaDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.model.Cjenovnik;
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
}
