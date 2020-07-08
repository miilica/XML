package com.repository;

import com.model.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {
    List<Komentar> findAllByVoziloId(Long id);

    List<Komentar> findAllByVoziloIdAndOdobren(Long id, boolean b);
}
