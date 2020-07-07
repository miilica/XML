package com.dto;

import lombok.*;

import javax.persistence.Column;

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
}
