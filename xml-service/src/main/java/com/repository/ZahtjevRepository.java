package com.repository;

import com.model.User;
import com.model.Zahtjev;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZahtjevRepository extends JpaRepository<Zahtjev, Long> {
    List<Zahtjev> findByOglasId(Long id);

    List<Zahtjev> findAllByUserIzdao(User u);

    List<Zahtjev> findAllByUserPoslao(User u);
}
