package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.model.Zahtjev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZahtjevRepository extends JpaRepository<Zahtjev, Long> {
    List<Zahtjev> findByOglasId(Long id);

    List<Zahtjev> findAllByUserIzdao(User u);

    List<Zahtjev> findAllByUserPoslao(User u);
}
