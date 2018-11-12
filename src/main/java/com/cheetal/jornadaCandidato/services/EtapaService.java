package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.Etapa;
import com.cheetal.jornadaCandidato.domain.ProcessoSeletivo;
import com.cheetal.jornadaCandidato.repositories.AvaliacaoRepository;
import com.cheetal.jornadaCandidato.repositories.CalendarioEtapaRepository;
import com.cheetal.jornadaCandidato.repositories.EtapaRepository;
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
public class EtapaService {
    private final EtapaRepository repo;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private CalendarioEtapaRepository calendarioEtapaRepository;

    @Autowired
    private ProcessoSeletivoRepository processoSeletivoRepository;

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
        ProcessoSeletivo processoSeletivo = processoSeletivoRepository.getOne(obj.getProcessoSeletivo().getId());
        return repo.save(obj);
    }

    public Etapa update(Etapa obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public List<Etapa> findAll() {
        return repo.findAll();
    }

    public Page<Etapa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public void delete(Integer id) {
        Etapa obj = find(id);
        avaliacaoRepository.deleteInBatch(obj.getAvaliacaos());
        calendarioEtapaRepository.deleteInBatch(obj.getCalendarioEtapas());
        repo.deleteById(id);
    }
}
