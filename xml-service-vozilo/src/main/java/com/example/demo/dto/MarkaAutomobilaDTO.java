package com.example.demo.dto;

import com.model.MarkaAutomobila;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkaAutomobilaDTO {

    private Long id;
    private String nazivMarke;
    private String model;

    public  MarkaAutomobilaDTO (MarkaAutomobila markaAutomobila) {
        id = markaAutomobila.getId();
        nazivMarke = markaAutomobila.getNazivMarke();
        model = markaAutomobila.getModel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivMarke() {
        return nazivMarke;
    }

    public void setNazivMarke(String nazivMarke) {
        this.nazivMarke = nazivMarke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
