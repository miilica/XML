package com.repository;

import com.model.KorpaVozila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorpaVozilaRepository extends JpaRepository<KorpaVozila, Long> {
}
