package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "zahtjev")
public class Zahtjev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date datumKreiranja;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")})
    private DateTime Od;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")})
    private DateTime Doo;


    @Column
    private boolean potvrdjen;

    @Column
    private  boolean bundle;

    //agent ciji je oglas
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    //user koji je poslao zahtjev
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_poslao_id")
    private User userPoslao;

    //user ciji je oglas
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_izdao_id")
    private User userIzdao;

    @Column
    private String zahtjevStatus;

    //iznajmljivanje pojedinacnih vozila
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    //iznajmljivanje vozila u bundle
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "korpavozila_id")
    private Set<KorpaVozila> korpaVozilaDTOS = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Oglas oglas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public DateTime getOd() {
        return Od;
    }

    public void setOd(DateTime od) {
        Od = od;
    }

    public DateTime getDoo() {
        return Doo;
    }

    public void setDoo(DateTime doo) {
        Doo = doo;
    }

    public boolean isPotvrdjen() {
        return potvrdjen;
    }

    public void setPotvrdjen(boolean potvrdjen) {
        this.potvrdjen = potvrdjen;
    }

    public boolean isBundle() {
        return bundle;
    }

    public void setBundle(boolean bundle) {
        this.bundle = bundle;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public User getUserPoslao() {
        return userPoslao;
    }

    public void setUserPoslao(User userPoslao) {
        this.userPoslao = userPoslao;
    }

    public User getUserIzdao() {
        return userIzdao;
    }

    public void setUserIzdao(User userIzdao) {
        this.userIzdao = userIzdao;
    }

    public String getZahtjevStatus() {
        return zahtjevStatus;
    }

    public void setZahtjevStatus(String zahtjevStatus) {
        this.zahtjevStatus = zahtjevStatus;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Set<KorpaVozila> getKorpaVozilaDTOS() {
        return korpaVozilaDTOS;
    }

    public void setKorpaVozilaDTOS(Set<KorpaVozila> korpaVozilaDTOS) {
        this.korpaVozilaDTOS = korpaVozilaDTOS;
    }

    public Oglas getOglas() {
        return oglas;
    }

    public void setOglas(Oglas oglas) {
        this.oglas = oglas;
    }

    //private StatusZahtjeva statusZahtjeva;
}
