package com.example.demo.dto;

import com.example.demo.model.TipGoriva;

public class VrstaGorivaDTO {

    private Long id;
    private String naziv;

    public  VrstaGorivaDTO (TipGoriva tipGoriva) {
        id = tipGoriva.getId();
        naziv = tipGoriva.getNaziv();
    }

    public VrstaGorivaDTO() {
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
