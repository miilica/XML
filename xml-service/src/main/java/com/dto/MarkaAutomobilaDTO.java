package com.dto;

import com.model.MarkaAutomobila;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MarkaAutomobilaDTO {
    private Long id;
    private String nazivMake;
    private String model;

    public  MarkaAutomobilaDTO (MarkaAutomobila markaAutomobila) {
        id = markaAutomobila.getId();
        nazivMake = markaAutomobila.getNazivMarke();
        model = markaAutomobila.getModel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivMake() {
        return nazivMake;
    }

    public void setNazivMake(String nazivMake) {
        this.nazivMake = nazivMake;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
