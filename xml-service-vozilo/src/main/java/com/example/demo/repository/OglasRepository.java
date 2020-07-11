package com.example.demo.repository;

import com.example.demo.model.Oglas;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Long> {

    Oglas findById(String id);

    @Query("select o from Oglas o where o.mjestoPreuzimanja = (?1) and o.od <= (?2) and o.doo >= (?3) and (o.vozilo.markaAutomobila.model = (?4) or (?4) is null) and (o.vozilo.markaAutomobila.id = (?5) or (?5) is null) and" +
            "(o.vozilo.klasaAutomobila.id = (?6) or (?6) is null) and (o.vozilo.tipGoriva.id = (?7) or (?7) is null) and (o.vozilo.tipMjenjaca.id = (?8) or (?8) is null) and (o.cjenovnik.cijenaPoDanu >= (?9) and o.cjenovnik.cijenaPoDanu <= (?10)) and" +
            "(o.vozilo.kilometraza >=(?11) and o.vozilo.kilometraza <= (?12)) and (o.dozvoljenaKilometraza <= (?13) or (?13)=0.0 or o.dozvoljenaKilometraza = 0.0) and (o.vozilo.brSjedistaZaDjecu = (?15) or (?15)=0) and (o.vozilo.coliisionDamageWavier = (?14) or (?14) = false)" )
    Page<Oglas> pretraziOglase(String mjesto, DateTime od, DateTime doo, String model, Long markaId, Long klasaId, Long gorivoId, Long mjenjacId, Double cijenaOd, Double cijenaDo, Double kilometrazaOd, Double kilometrazaDo, Double kilometrazaDozvoljena, Boolean cdw, Integer brojMjestaDjeca, Pageable pageable);
}
