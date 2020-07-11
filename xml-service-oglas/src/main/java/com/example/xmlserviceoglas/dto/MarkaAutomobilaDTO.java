package com.example.xmlserviceoglas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkaAutomobilaDTO {

    private Long id;
    private String nazivMarke;
    private String model;
    private Set<VoziloDTO> vozila;
}
