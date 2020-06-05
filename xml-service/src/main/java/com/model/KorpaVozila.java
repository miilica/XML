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
public class KorpaVozila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String kilometraza;

    @Column
    private String ocjena;

    @Column
    private String cjena;

    @Column
    private String mozePreciKM;

    @Column
    private Long userId;

    @Column
    private Long vehicleId;

}
