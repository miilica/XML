package com.dto;

import com.model.Oglas;
import com.model.Vozilo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OglasDTO {

    private Long id;
    private boolean dostupan;
    private Vozilo vozilo;
    private String mestoPreuzimanja;

    public OglasDTO(Oglas oglas) {
        this.id = oglas.getId();
        this.dostupan = oglas.isDostupan();
        this.vozilo = oglas.getVozilo();
        this.mestoPreuzimanja = oglas.getMjestoPreuzimanja();
    }

}
