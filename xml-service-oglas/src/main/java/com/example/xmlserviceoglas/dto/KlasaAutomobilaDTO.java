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
public class KlasaAutomobilaDTO {

    private String naziv;
    private Long id;
    private Set<VoziloDTO> vozilo;
}
