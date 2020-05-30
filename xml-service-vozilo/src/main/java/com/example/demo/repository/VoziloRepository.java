package com.example.demo.repository;

import com.example.demo.model.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoziloRepository extends JpaRepository<Vozilo, Long> {
}
