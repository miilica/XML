package com.repository;

import com.model.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoziloRepository extends JpaRepository<Vozilo, Long> {
    Vozilo findById (String id);
}
