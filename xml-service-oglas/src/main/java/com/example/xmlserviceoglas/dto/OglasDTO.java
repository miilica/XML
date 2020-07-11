package com.example.xmlserviceoglas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OglasDTO {

    private Long id;
    private boolean dostupan;
    private VoziloDTO vozilo;
    private String mestoPreuzimanja;
    private DateTime od;
    private DateTime doo;
    private Long userId;
    private Long cjenovnikID;
}
