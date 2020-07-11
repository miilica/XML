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
public class KorpaVozila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double cijena;

    @Column
    private double kilometraza;

    @Column
    private double mozePreciKM;

    @Column
    private int brSjedistaZaDjecu;

    @Column
    private double ocjena;

    @Column
    private Boolean imaAndroid;

    @Column
    private boolean coliisionDamageWavier;

    @Column
    private  boolean bundle;

    @Column
    private Long userId;

    @Column
    private Long vehicleId;

    @ManyToOne()
    @JoinColumn(name = "agent_id")
    private Agent agent;

}
