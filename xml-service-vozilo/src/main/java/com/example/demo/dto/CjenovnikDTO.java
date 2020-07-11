package com.example.demo.dto;

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
}
