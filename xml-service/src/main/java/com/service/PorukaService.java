package com.service;

import com.dto.PorukaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PorukaService {
    void novaPoruka();

    void getByUser();

    void  posaljiPoruku(PorukaDTO porukaDTO);

    List<PorukaDTO> get(Long posiljalacId, Long primalacId, Long oglasId);

    List<PorukaDTO> getMojePoruke(Long id);
}
