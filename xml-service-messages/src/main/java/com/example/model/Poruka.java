package com.example.model;

import lombok.*;


import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Poruka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sadrzaj;

    @Column
    private Date datum;

    @Column
    private Long posiljalacId;

    @Column
    private Long primalacId;

    @Column
    private Long oglasId;
}
