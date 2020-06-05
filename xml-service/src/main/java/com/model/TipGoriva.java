package com.model;

import com.dto.VrstaGorivaDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vrstagoriva")
public class TipGoriva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @OneToMany(mappedBy = "tipGoriva", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;

    public TipGoriva(String naziv) {
        this.naziv = naziv;
    }

    public TipGoriva() {
    }
    public TipGoriva(VrstaGorivaDTO g) {
        this.setNaziv(g.getNaziv());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
