package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cjenovnik")
public class Cjenovnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double radDanCijena;

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

    @OneToMany(mappedBy = "cjenovnik", fetch = FetchType.LAZY)
    private Set<Oglas> oglasi;
}
