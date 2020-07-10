package com.example.demo.dto;

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
}
