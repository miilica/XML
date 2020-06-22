package com.repository;

import com.dto.PorukaDTO;
import com.model.Poruka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PorukaRepository extends JpaRepository<Poruka, Long> {
    List<Poruka> findAll();

    List<PorukaDTO> findAllByPrimalacId(Long id);
}
