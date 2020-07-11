package com.example.demo.model;


import com.example.demo.dto.MarkaAutomobilaDTO;

import javax.persistence.*;

@Entity
@Table(name="markaautomobila")
public class MarkaAutomobila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nazivMarke;

    @Column
    private String model;

    @Column
    private boolean obrisan;

    public MarkaAutomobila() {
    }

    public MarkaAutomobila(MarkaAutomobilaDTO m) {
        this.setNazivMarke(m.getNazivMarke());
        this.setModel(m.getModel());
        this.setObrisan(false);

    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
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
