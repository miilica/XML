package com.example.xmlserviceoglas.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Oglas {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean dostupan;

    @Column
    private String mjestoPreuzimanja;

    @Column
    private Double dozvoljenaKilometraza;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Cjenovnik cjenovnik;

    @JsonIgnore
    @OneToMany(mappedBy = "oglas")
    private Set<Komentar> komentari;

    @JsonIgnore//uleti u neku beskonacnu petlju kad uzimam sve oglase pa sam morao ovo
    @ManyToOne(fetch = FetchType.EAGER)
    private Vozilo vozilo;

    @JsonIgnore
    @OneToMany(mappedBy = "oglas")
    private Set<Ocena> ocjene;

    @OneToMany(mappedBy = "oglas", fetch = FetchType.LAZY)
    private Set<Zahtjev> zahtjevp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
