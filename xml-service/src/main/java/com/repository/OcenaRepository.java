package com.repository;

import com.model.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {


    List<Ocena> findAllByVoziloId(Long voziloId);
}
