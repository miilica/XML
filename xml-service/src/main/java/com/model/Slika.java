package com.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Slika {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30000)
    private String info;

    @Column(length = 30000)
    private String tip;

    @Lob
    @Column(name = "slika", columnDefinition="LONGBLOB")
    private Blob image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    public Slika() {
    }

    public Slika(String info, String tip, Blob image, Vozilo vozilo) {
        this.info = info;
        this.tip = tip;
        this.image = image;
        this.vozilo = vozilo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }
}
