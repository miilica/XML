package com.example.demo.repository;

import com.example.demo.model.Oglas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface PretragaRepository extends JpaRepository<Oglas, Long> {


    @Query("select oglas from Oglas oglas where oglas.mjestoPreuzimanja = ?1 and oglas.oglasVaziOd <= (?3) and oglas.oglasVaziDo >= (?2) ")
    List<Oglas> pretrazi(String mjestoPreuzimanja, Date doo, Date od);

}
