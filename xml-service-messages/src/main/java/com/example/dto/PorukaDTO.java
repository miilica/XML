package com.example.dto;



import com.example.model.Poruka;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PorukaDTO {
    private Long id;

    private String sadrzaj;

    private Date datum;

    private Long posiljalacId;

    private Long primalacId;

    private Long oglasId;

    public PorukaDTO(Poruka p){
        this.id = p.getId();
        this.sadrzaj = p.getSadrzaj();
        this.datum = p.getDatum();
        this.oglasId = p.getOglasId();
        this.posiljalacId = p.getPosiljalacId();
        this.primalacId = p.getPrimalacId();

    }
}
