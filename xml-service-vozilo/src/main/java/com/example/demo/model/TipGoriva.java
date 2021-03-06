package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "vrstagoriva")
public class TipGoriva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private Boolean obrisan;

    @JsonIgnore
    @OneToMany(mappedBy = "tipGoriva", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;

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

    public void setObrisan(boolean b) {
        this.obrisan = b;
    }

    public boolean getObrisan() {
        return  obrisan;
    }
}
