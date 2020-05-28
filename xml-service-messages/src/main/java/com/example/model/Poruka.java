package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Poruka {

    private Long id;

    private String sadrzaj;

    private Date datum;

    //private User poslijalac;
    private String senderId;

    //private User primalac;
    private String reciverId;
}
