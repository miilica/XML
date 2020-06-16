package com.repository;

import com.model.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoziloRepository extends JpaRepository<Vozilo, Long> {

}
