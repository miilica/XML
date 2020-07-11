package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OcenaDTO {
    private Long id;
    private Double ocena;
    private String userUsername;
    private Long userId;
    private Long voziloId;
    private Long oglasId;
}
