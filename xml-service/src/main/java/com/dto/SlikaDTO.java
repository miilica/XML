package com.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Blob;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlikaDTO {
    private String info;
    private String tip;
    private Blob slika;
}