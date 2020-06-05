package com.model;

import com.dto.MarkaAutomobilaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="markaautomobila")
@Getter
@Setter
public class MarkaAutomobila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nazivMarke;

    @Column
    private String model;

    @OneToMany(mappedBy = "markaAutomobila", fetch = FetchType.LAZY)
    private Set<Vozilo> vozila;

    public MarkaAutomobila(MarkaAutomobilaDTO m) {
        this.setNazivMarke(m.getNazivMake());
        this.setModel(m.getModel());
    }

    public MarkaAutomobila() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivMarke() {
        return nazivMarke;
    }

    public void setNazivMarke(String nazivMarke) {
        this.nazivMarke = nazivMarke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
