package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pretraga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date od;

    @Column
    private Date doo;

    @Column
    private String modelVozila;

    @Column
    private String markaVozila;

    @Column
    private String klasaVozila;

    @Column
    private double kilometraza;

    @Column
    private double cijena;

    @Column
    private double ocjena;

    @Column
    private VrstaGoriva gorivo;

    @Column
    private TipMjenjanca mjenjac;

    @Column
    private String imeKompanije;

}
