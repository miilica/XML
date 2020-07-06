package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "oglasi")
public class Oglas {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean dostupan;

    @Column
    private boolean obrisan;

    @JsonIgnore//uleti u neku beskonacnu petlju kad uzimam sve oglase pa sam morao ovo
    @ManyToOne(fetch = FetchType.EAGER)
    private Vozilo vozilo;

    @Column
    private String mjestoPreuzimanja;

    //private TerminIznajmljivanja terminIznajmljivanja;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cjenovnik cjenovnik;

    @OneToMany(mappedBy = "oglas", fetch = FetchType.LAZY)
    private Set<Zahtjev> zahtjev;

    //private List<String> slike;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDostupan() {
        return dostupan;
    }

    public void setDostupan(boolean dostupan) {
        this.dostupan = dostupan;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public String getMjestoPreuzimanja() {
        return mjestoPreuzimanja;
    }

    public void setMjestoPreuzimanja(String mjestoPreuzimanja) {
        this.mjestoPreuzimanja = mjestoPreuzimanja;
    }

    public Cjenovnik getCjenovnik() {
        return cjenovnik;
    }

    public void setCjenovnik(Cjenovnik cjenovnik) {
        this.cjenovnik = cjenovnik;
    }
}
