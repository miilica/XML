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
@Table(name = "ocena")
public class Ocena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double ocena;

    //user koji je dao ocenu
    private Long userId;

    //vozilo koje se ocenjuje
    @ManyToOne()
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    @ManyToOne
    @JoinColumn(name = "oglas_id")
    private Oglas oglas;
}
