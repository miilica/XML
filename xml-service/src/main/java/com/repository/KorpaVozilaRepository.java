package com.repository;

import com.dto.VoziloDTO;
import com.model.KorpaVozila;
import com.model.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorpaVozilaRepository extends JpaRepository<KorpaVozila, Long> {
}
