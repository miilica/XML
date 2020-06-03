package com.model;

import javax.persistence.*;

@Entity
@Table(name = "vrstagoriva")
public class TipGoriva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    public TipGoriva(String naziv) {
        this.naziv = naziv;
    }

    public TipGoriva() {
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
