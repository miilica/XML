package com.example.xmlserviceoglas.dto;

import com.example.xmlserviceoglas.model.Izvjestaj;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IzvjestajDTO {

    private Long id;
    private String komentar;
    private double predjeniKilometri;
    private VoziloDTO vozilo;

    public IzvjestajDTO(Izvjestaj izvjestaj){
        this.id = izvjestaj.getId();
        this.komentar = izvjestaj.getKomentar();
        this.predjeniKilometri = izvjestaj.getPredjeniKilometri();
    }
}
