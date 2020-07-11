package com.example.demo.repository;

import com.example.demo.model.TipGoriva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaGorivaRepository extends JpaRepository<TipGoriva, Long> {

    TipGoriva findById(String id);
}
