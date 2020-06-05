package com.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Izvjestaj {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String komentar;

    @Column
    private double predjeniKilometri;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vozilo vozilo;
}
