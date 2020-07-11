package com.example.xmlserviceoglas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MarkaAutomobila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nazivMarke;

    @Column
    private String model;

    @Column
    private Boolean obrisan;

    @OneToMany(mappedBy = "markaAutomobila", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;
}
