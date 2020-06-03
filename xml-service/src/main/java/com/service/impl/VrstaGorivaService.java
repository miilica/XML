package com.service.impl;

import com.dto.VrstaGorivaDTO;
import com.model.TipGoriva;
import com.repository.VrstaGorivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class VrstaGorivaService {
        @Autowired
        private VrstaGorivaRepository vrstaGorivaRepository;

        public TipGoriva findById(Long id) throws AccessDeniedException {
            TipGoriva u = vrstaGorivaRepository.findById(id).orElseGet(null);
            return u;
        }


        public TipGoriva save(VrstaGorivaDTO mDTO) {
            TipGoriva m = new TipGoriva();
            m.setNaziv(mDTO.getNaziv());

            m = this.vrstaGorivaRepository.save(m);
            return m;
        }
}
