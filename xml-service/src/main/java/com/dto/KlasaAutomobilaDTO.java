package com.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KlasaAutomobilaDTO {
    private String naziv;
    private Long id;


    public KlasaAutomobilaDTO() {
    }

    public KlasaAutomobilaDTO(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getID() {
        return id;
    }


}
