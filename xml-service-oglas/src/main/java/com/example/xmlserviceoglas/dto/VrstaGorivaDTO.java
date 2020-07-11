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
public class VrstaGorivaDTO {

    private Long id;
    private String naziv;
    private Boolean obrisan;
    private Set<VoziloDTO> vozila;
}
