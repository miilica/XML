package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.dto.KlasaAutomobilaDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="klasaautomobila")
public class KlasaAutomobila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @OneToMany(mappedBy = "klasaAutomobila", fetch = FetchType.LAZY)
    private Set<Vozilo> vozilo;


    public KlasaAutomobila(String naziv) {
        this.naziv = naziv;
    }

    public KlasaAutomobila(KlasaAutomobilaDTO k) {
        this.setNaziv(k.getNaziv());
    }

    public KlasaAutomobila() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
