package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.ProcessoSeletivo;
import com.cheetal.jornadaCandidato.repositories.ProcessoSeletivoRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessoSeletivoService {
    private final ProcessoSeletivoRepository repo;

    @Autowired
    public ProcessoSeletivoService(ProcessoSeletivoRepository repo) {
        this.repo = repo;
    }

    public ProcessoSeletivo find(Integer id) {
        Optional<ProcessoSeletivo> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + ProcessoSeletivo.class.getName()));
    }

    public ProcessoSeletivo insert(ProcessoSeletivo obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public ProcessoSeletivo update(ProcessoSeletivo obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        ProcessoSeletivo obj = find(id);
        repo.deleteById(id);
    }
}
