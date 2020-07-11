package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "termin_iznajmljivanja")
public class TerminIznajmljivanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_from", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    private DateTime dateFrom;


    @Column(name = "date_to", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
            @org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"),
            @org.hibernate.annotations.Parameter(name = "javaZone", value = "UTC")
    })
    private DateTime dateTo;


    //koji user iznajmljuje
    @Column
    private Long userId;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    public TerminIznajmljivanja() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(DateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public DateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(DateTime dateTo) {
        this.dateTo = dateTo;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }


}
