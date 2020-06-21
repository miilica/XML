package com.dto;

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
}
