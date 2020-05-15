package com.model;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class Agent extends User {
    private String ime;
    private String prezime;
    private String adresa;
    private String imeKopanije;
    private String poslovniMB;
    private List<Vozilo> vozila;
    private List<Oglas> oglasi;
    private int brOglasa;
    private List<Zahtjev> pristigliZahtjevi;


}
