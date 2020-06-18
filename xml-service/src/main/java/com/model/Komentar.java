package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "komentar")
public class Komentar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tekst;

    @Column
    private boolean odobren;

    @ManyToOne()
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    // user koji je ostavio komentar
    @Column
    private Long userId;


   // private Agent agent;
   // private Korisnik korisnik;
}
