package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="oglas")
public class Oglas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean dostupan;

    @Column
    private String mjestoPreuzimanja;

    @Column
    private Date oglasVaziOd;

    @Column
    private Date oglasVaziDo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vozilo vozilo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cjenovnik cjenovnik;

}
