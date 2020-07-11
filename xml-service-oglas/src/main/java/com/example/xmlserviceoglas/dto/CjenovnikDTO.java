package com.example.xmlserviceoglas.dto;

import com.example.xmlserviceoglas.model.Agent;
import com.example.xmlserviceoglas.model.Cjenovnik;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CjenovnikDTO {
    private Long id;
    private double cijenaPoDanu;
    private double cijenaPoKM;
    private double cijenaCDW;
    private double popust;
    private String userUsername;

    public CjenovnikDTO(Cjenovnik cjenovnik){
        this.id = cjenovnik.getId();
        this.cijenaPoDanu = cjenovnik.getCijenaPoDanu();
        this.cijenaPoKM = cjenovnik.getCijenaPoKM();
        this.cijenaCDW = cjenovnik.getCijenaCDW();
        this.popust = cjenovnik.getPopust();
        this.userUsername = cjenovnik.getUser().getUsername();
    }
}
