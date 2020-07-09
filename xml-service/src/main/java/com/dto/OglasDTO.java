package com.dto;

import com.model.Oglas;
import com.model.Vozilo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import org.joda.time.DateTime;


@AllArgsConstructor
@Getter
@Setter
public class OglasDTO {

    private Long id;
    private boolean dostupan;
    private VoziloDTO vozilo;
    private String mestoPreuzimanja;
    private DateTime od;
    private DateTime doo;
    private Long userId;
    private Long cjenovnikID;

    public OglasDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDostupan(boolean dostupan) {
        this.dostupan = dostupan;
    }

    public void setVozilo(VoziloDTO vozilo) {
        this.vozilo = vozilo;
    }

    public void setMestoPreuzimanja(String mestoPreuzimanja) {
        this.mestoPreuzimanja = mestoPreuzimanja;
    }

    public void setOd(DateTime od) {
        this.od = od;
    }

    public void setDoo(DateTime doo) {
        this.doo = doo;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCjenovnikID(Long cjenovnikID) {
        this.cjenovnikID = cjenovnikID;
    }

    public Long getId() {
        return id;
    }

    public boolean isDostupan() {
        return dostupan;
    }

    public VoziloDTO getVozilo() {
        return vozilo;
    }

    public String getMestoPreuzimanja() {
        return mestoPreuzimanja;
    }

    public DateTime getOd() {
        return od;
    }

    public DateTime getDoo() {
        return doo;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCjenovnikID() {
        return cjenovnikID;
    }
}
