package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.Origem;
import com.cheetal.jornadaCandidato.repositories.OrigemRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrigemService {
    private final OrigemRepository repo;

    @Autowired
    public OrigemService(OrigemRepository repo) {
        this.repo = repo;
    }

    public Origem find(Integer id) {
        Optional<Origem> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Origem.class.getName()));
    }

    public Origem insert(Origem obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Origem update(Origem obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public List<Origem> findAll() {
        return repo.findAll();
    }

    public Page<Origem> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }
}
