package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.CalendarioEtapa;
import com.cheetal.jornadaCandidato.domain.ProcessoSeletivo;
import com.cheetal.jornadaCandidato.repositories.CalendarioEtapaRepository;
import com.cheetal.jornadaCandidato.repositories.ProcessoSeletivoRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioEtapaService {
    private final CalendarioEtapaRepository repo;

    @Autowired
    public CalendarioEtapaService(CalendarioEtapaRepository repo) {
        this.repo = repo;
    }

    public CalendarioEtapa find(Integer id) {
        Optional<CalendarioEtapa> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + CalendarioEtapa.class.getName()));
    }

    public CalendarioEtapa insert(CalendarioEtapa obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public List<CalendarioEtapa> findAll() {
        return repo.findAll();
    }

    public Page<CalendarioEtapa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
}
