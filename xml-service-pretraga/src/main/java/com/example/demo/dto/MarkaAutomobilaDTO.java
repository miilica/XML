package com.example.demo.dto;

import com.example.demo.model.MarkaAutomobila;
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
    private String nazivMake;
    private String model;

    public MarkaAutomobilaDTO(MarkaAutomobila markaAutomobila) {
        id = markaAutomobila.getId();
        nazivMake = markaAutomobila.getNazivMarke();
        model = markaAutomobila.getModel();
    }
}
