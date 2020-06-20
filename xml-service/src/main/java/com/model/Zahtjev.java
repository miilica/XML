package com.model;

import com.dto.KorpaVozilaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
    private Set<KorpaVozila> korpaVozila = new HashSet<>();

    //@ManyToOne(fetch = FetchType.LAZY)
    //private Set<Oglas> oglasi;

    //private StatusZahtjeva statusZahtjeva;
}
