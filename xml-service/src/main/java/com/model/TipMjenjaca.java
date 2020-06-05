package com.model;

import com.dto.TipMjenjacaDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tipmjenjaca")
public class TipMjenjaca {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String naziv;

    @OneToMany(mappedBy = "tipMjenjaca", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;

    public TipMjenjaca(String naziv) {
        this.naziv = naziv;
    }

    public TipMjenjaca() {
    }
    public TipMjenjaca(TipMjenjacaDTO t) {
        this.setNaziv(t.getNaziv());
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
