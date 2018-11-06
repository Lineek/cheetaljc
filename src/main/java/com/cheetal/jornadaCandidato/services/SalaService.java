package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.Sala;
import com.cheetal.jornadaCandidato.repositories.SalaRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    private final SalaRepository repo;

    @Autowired
    public SalaService(SalaRepository repo) {
        this.repo = repo;
    }

    public Sala find(Integer id) {
        Optional<Sala> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Sala.class.getName()));
    }

    public List<Sala> findAll() {
        return repo.findAll();
    }

    public Page<Sala> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Sala insert(Sala obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
