package com.repository;

import com.model.TipMjenjaca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipMjenjacaRepository extends JpaRepository<TipMjenjaca, Long> {

    TipMjenjaca findById(String id);
}
