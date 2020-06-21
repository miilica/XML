package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "termin_iznajmljivanja")
public class TerminIznajmljivanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date odKad;

    @Column
    private Date doKad;

    //koji user iznajmljuje
    @Column
    private Long userId;

    @ManyToOne()
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;
}