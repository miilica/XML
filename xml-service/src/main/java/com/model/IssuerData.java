package com.model;

import lombok.*;

import java.security.PrivateKey;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssuerData {
    private PrivateKey privateKey;
    //private X500Name x500name;

}
