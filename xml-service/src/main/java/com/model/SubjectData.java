package com.model;

import lombok.*;
import sun.security.x509.X500Name;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectData {
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private X500Name x500name;
    private String serialNumber;
    private Date startDate;
    private Date endDate;


}
