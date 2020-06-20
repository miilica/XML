package com.example.demo.dto;

import com.example.demo.model.Cjenovnik;
import com.example.demo.model.Vozilo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OglasDTO {

    private Long id;
    private boolean dostupan;
    private String mjestoPreuzimanja;
    private Date oglasVaziOd;
    private Date oglasVaziDo;
    private VoziloDTO vozilo;
    private CjenovnikDTO cjenovnik;
}
