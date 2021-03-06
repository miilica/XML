package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "oglasi")
public class Oglas {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean dostupan;

    @Column(name = "doo")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    private DateTime doo;

    @Column(name = "od")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    private DateTime od;


    @JsonIgnore//uleti u neku beskonacnu petlju kad uzimam sve oglase pa sam morao ovo
    @ManyToOne(fetch = FetchType.EAGER)
    private Vozilo vozilo;

    @Column
    private String mjestoPreuzimanja;

    @Column
    private Double dozvoljenaKilometraza;

   // @Column
   // private TerminIznajmljivanja terminIznajmljivanja;

    @Column(name = "from_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    private DateTime fromDate;

    @Column(name = "to_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    private DateTime toDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Cjenovnik cjenovnik;




    @JsonIgnore
    @OneToMany(mappedBy = "oglas")
    private Set<Komentar> komentari;

    @JsonIgnore
    @OneToMany(mappedBy = "oglas")
    private Set<Ocena> ocjene;

    public Oglas() {
    }

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

    public DateTime getDoo() {
        return doo;
    }

    public void setDoo(DateTime doo) {
        this.doo = doo;
    }

    public DateTime getOd() {
        return od;
    }

    public void setOd(DateTime od) {
        this.od = od;
    }

    public Double getDozvoljenaKilometraza() {
        return dozvoljenaKilometraza;
    }

    public void setDozvoljenaKilometraza(Double dozvoljenaKilometraza) {
        this.dozvoljenaKilometraza = dozvoljenaKilometraza;
    }

    public Cjenovnik getCjenovnik() {
        return cjenovnik;
    }

    public void setCjenovnik(Cjenovnik cjenovnik) {
        this.cjenovnik = cjenovnik;
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

    public DateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(DateTime fromDate) {
        this.fromDate = fromDate;
    }

    public DateTime getToDate() {
        return toDate;
    }

    public void setToDate(DateTime toDate) {
        this.toDate = toDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }

    public Set<Ocena> getOcjene() {
        return ocjene;
    }

    public void setOcjene(Set<Ocena> ocjene) {
        this.ocjene = ocjene;
    }
}
