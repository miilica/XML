package com.model;

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
public class Cjenovnik {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 //   @OneToMany(mappedBy = "cjenovnik", fetch = FetchType.LAZY)
   // private Set<Oglas> oglasi;

    @Column
    private double ponCijena;

    @Column
    private double utoCijena;

    @Column
    private double sriCijena;

    @Column
    private double cetCijena;

    @Column
    private double petCijena;

    @Column
    private double subotaCijena;

    @Column
    private double nedeljaCijena;

    @Column
    private double cijenaPoKM;

    @Column
    private double cijenaCDW;

    @Column
    private double popust;
}
