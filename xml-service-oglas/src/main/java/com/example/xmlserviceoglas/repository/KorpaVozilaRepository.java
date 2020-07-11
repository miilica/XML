package com.example.xmlserviceoglas.repository;

import com.example.xmlserviceoglas.model.KorpaVozila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface KorpaVozilaRepository extends JpaRepository<KorpaVozila, Long> {
}
