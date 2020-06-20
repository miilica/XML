package com.example.demo.dto;

import com.example.demo.model.Oglas;
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
public class CjenovnikDTO {

    private Long id;
    private double radDanCijena;
    private double subotaCijena;
    private double nedeljaCijena;
    private double cijenaPoKM;
    private double cijenaCDW;
    private double popust;
}
