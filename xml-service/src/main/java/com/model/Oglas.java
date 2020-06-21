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
}
