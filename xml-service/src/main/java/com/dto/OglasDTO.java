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
    private DateTime fromDate;
    private DateTime toDate;
    private Long userId;
    private Long cjenovnikID;

    public OglasDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDostupan() {
        return dostupan;
    }

    public void setDostupan(boolean dostupan) {
        this.dostupan = dostupan;
    }

    public VoziloDTO getVozilo() {
        return vozilo;
    }

    public void setVozilo(VoziloDTO vozilo) {
        this.vozilo = vozilo;
    }

    public String getMestoPreuzimanja() {
        return mestoPreuzimanja;
    }

    public void setMestoPreuzimanja(String mestoPreuzimanja) {
        this.mestoPreuzimanja = mestoPreuzimanja;
    }

    public DateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(DateTime fromDate) {
        this.fromDate = fromDate;
    }

    public DateTime getToDate() {
        return toDate;
    }

    public void setToDate(DateTime toDate) {
        this.toDate = toDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCjenovnikID() {
        return cjenovnikID;
    }

    public void setCjenovnikID(Long cjenovnikID) {
        this.cjenovnikID = cjenovnikID;
    }

}
