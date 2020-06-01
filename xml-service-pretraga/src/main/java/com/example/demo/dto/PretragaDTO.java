package com.example.demo.dto;

import com.example.demo.model.Pretraga;
import com.example.demo.model.TipMjenjanca;
import com.example.demo.model.VrstaGoriva;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class PretragaDTO {

    private Long idDTO;

    private Date odDTO;

    private Date dooDTO;

    private String modelVozilaDTO;

    private String klasaVozilaDTO;

    private double kilometrazaDTO;

    private double cijenaDTO;

    private double ocjenaDTO;

    private VrstaGoriva gorivoDTO;

    private TipMjenjanca mjenjacDTO;

    private String imeKompanijeDTO;

    public PretragaDTO(){

    }

    public PretragaDTO(Pretraga pretraga){
        idDTO = pretraga.getId();
        odDTO = pretraga.getOd();
        dooDTO = pretraga.getDoo();
        modelVozilaDTO = pretraga.getModelVozila();
        klasaVozilaDTO = pretraga.getKlasaVozila();
        kilometrazaDTO = pretraga.getKilometraza();
        cijenaDTO = pretraga.getCijena();
        ocjenaDTO = pretraga.getOcjena();
        gorivoDTO = pretraga.getGorivo();
        mjenjacDTO = pretraga.getMjenjac();
        imeKompanijeDTO = pretraga.getImeKompanije();
    }


    public PretragaDTO(Long idDTO, Date odDTO, Date dooDTO, String modelVozilaDTO, String klasaVozilaDTO, double kilometrazaDTO, double cijenaDTO, double ocjenaDTO, VrstaGoriva gorivoDTO, TipMjenjanca mjenjacDTO, String imeKompanijeDTO) {
        this.idDTO = idDTO;
        this.odDTO = odDTO;
        this.dooDTO = dooDTO;
        this.modelVozilaDTO = modelVozilaDTO;
        this.klasaVozilaDTO = klasaVozilaDTO;
        this.kilometrazaDTO = kilometrazaDTO;
        this.cijenaDTO = cijenaDTO;
        this.ocjenaDTO = ocjenaDTO;
        this.gorivoDTO = gorivoDTO;
        this.mjenjacDTO = mjenjacDTO;
        this.imeKompanijeDTO = imeKompanijeDTO;
    }
}
