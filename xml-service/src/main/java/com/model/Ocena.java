package com.model;


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

    //vozilo koje se ocenjuje
    @ManyToOne()
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    private Double ocena;

    //user koji je dao ocenu
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "oglas_id")
    private Oglas oglas;
}
