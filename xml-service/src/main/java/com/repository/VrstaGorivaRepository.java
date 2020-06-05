package com.repository;

import com.model.TipGoriva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaGorivaRepository extends JpaRepository<TipGoriva, Long> {

    TipGoriva findById(String id);
}
