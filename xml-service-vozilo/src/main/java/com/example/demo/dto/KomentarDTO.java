package com.example.demo.dto;

import com.example.demo.model.Komentar;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KomentarDTO {
    private Long id;
    private  String tekst;
    private boolean odobren;
    private VoziloDTO vozilo;
    private Long userId;
    private String userUsername;

    public KomentarDTO(Komentar k) {
        this.id = k.getId();
        this.tekst = k.getTekst();
        this.odobren = k.isOdobren();
        this.vozilo = new VoziloDTO(k.getVozilo());
        this.userId = k.getUserId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }

    public VoziloDTO getVozilo() {
        return vozilo;
    }

    public void setVozilo(VoziloDTO vozilo) {
        this.vozilo = vozilo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
