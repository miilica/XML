package com.example.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PorukaDTO {
    private Long id;
    private String sadrzaj;
    private Date datum;
    private String senderId;
    private String reciverId;
}
