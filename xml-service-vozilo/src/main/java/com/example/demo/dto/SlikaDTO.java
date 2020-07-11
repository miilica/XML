package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlikaDTO {
    private String info;
    private String tip;
    private Blob slika;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Blob getSlika() {
        return slika;
    }

    public void setSlika(Blob slika) {
        this.slika = slika;
    }
}