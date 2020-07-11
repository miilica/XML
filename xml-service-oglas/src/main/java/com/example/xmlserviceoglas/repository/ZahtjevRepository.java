package com.example.xmlserviceoglas.repository;
import com.example.xmlserviceoglas.model.User;
import com.example.xmlserviceoglas.model.Zahtjev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface ZahtjevRepository extends JpaRepository<Zahtjev, Long> {

    List<Zahtjev> findByOglasId(Long id);
    List<Zahtjev> findAllByUserIzdao(User u);
    List<Zahtjev> findAllByUserPoslao(User u);
}
