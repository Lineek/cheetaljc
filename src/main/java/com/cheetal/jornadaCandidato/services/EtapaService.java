package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.Etapa;
import com.cheetal.jornadaCandidato.repositories.EtapaRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtapaService {
    private final EtapaRepository repo;

    @Autowired
    public EtapaService(EtapaRepository repo) {
        this.repo = repo;
    }

    public Etapa find(Integer id) {
        Optional<Etapa> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Etapa.class.getName()));
    }

    public Etapa insert(Etapa obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
