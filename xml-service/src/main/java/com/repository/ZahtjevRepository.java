package com.repository;

import com.model.Zahtjev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahtjevRepository extends JpaRepository<Zahtjev, Long> {
}
