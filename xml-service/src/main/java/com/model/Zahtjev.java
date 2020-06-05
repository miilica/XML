package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Zahtjev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date datumKreiranja;

    @Column
    private boolean potvrdjen;

    @Column
    private  boolean bandle;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    //@ManyToOne(fetch = FetchType.LAZY)
    //private Set<Oglas> oglasi;

    //private StatusZahtjeva statusZahtjeva;
}
