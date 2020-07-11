package com.model;

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
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    //user koji je poslao zahtjev
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_poslao_id")
    private User userPoslao;

    //user ciji je oglas
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_izdao_id")
    private User userIzdao;

    @Column
    private String zahtjevStatus;

    //iznajmljivanje pojedinacnih vozila
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    //iznajmljivanje vozila u bundle
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "korpavozila_id")
    private Set<KorpaVozila> korpaVozilaDTOS = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Oglas oglas;

}
