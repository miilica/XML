package com.service.impl;

import com.dto.TipMjenjacaDTO;
import com.model.TipMjenjaca;
import com.repository.TipMjenjacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipMjenjacaService {
    @Autowired
    private TipMjenjacaRepository tipMjenjacaRepository;

    public TipMjenjaca findById(Long id) throws AccessDeniedException {
        TipMjenjaca u = tipMjenjacaRepository.findById(id).orElseGet(null);
        return u;
    }

    public TipMjenjaca save(TipMjenjacaDTO mDTO) {
        TipMjenjaca m = new TipMjenjaca();
        m.setNaziv(mDTO.getNaziv());

        m = this.tipMjenjacaRepository.save(m);
        return m;
    }
    public List<TipMjenjaca> findAll() throws AccessDeniedException {
        List<TipMjenjaca> result = tipMjenjacaRepository.findAll();
        return result;
    }
}
