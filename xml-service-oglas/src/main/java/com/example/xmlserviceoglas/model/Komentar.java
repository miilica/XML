package com.example.xmlserviceoglas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Komentar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tekst;

    @Column
    private boolean odobren;

    // user koji je ostavio komentar
    @Column
    private Long userId;

    @ManyToOne()
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    @ManyToOne
    @JoinColumn(name = "oglas_id")
    private Oglas oglas;

}
