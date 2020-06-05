package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agent{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String adresa;

    @Column
    private String imeKompanije;

    @Column
    private String poslovniMB;

    @Column
    private int brOglasa;

    @JsonIgnore//uleti u neku beskonacnu petlju kad uzimam sve oglase pa sam morao ovo
    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;

    @JsonIgnore//uleti u neku beskonacnu petlju kad uzimam sve oglase pa sam morao ovo
    @OneToMany(mappedBy = "agent", fetch = FetchType.LAZY)
    private Set<Zahtjev> pristigliZahtjevi;

    //private Set<Oglas> oglasi;


}
