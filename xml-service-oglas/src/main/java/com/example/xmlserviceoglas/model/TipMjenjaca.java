package com.example.xmlserviceoglas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipMjenjaca {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String naziv;

        @Column
        private Boolean obrisan;

        @OneToMany(mappedBy = "tipMjenjaca", fetch = FetchType.LAZY)
        private Set<Vozilo> vozila;
}
