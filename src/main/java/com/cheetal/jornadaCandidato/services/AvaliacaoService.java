package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.Avaliacao;
import com.cheetal.jornadaCandidato.domain.Etapa;
import com.cheetal.jornadaCandidato.repositories.AvaliacaoRepository;
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
public class AvaliacaoService {
    private final AvaliacaoRepository repo;

    @Autowired
    private ProcessoSeletivoRepository processoSeletivoRepository;

    @Autowired
    private EtapaRepository etapaRepository;

    @Autowired
    public AvaliacaoService(AvaliacaoRepository repo) {
        this.repo = repo;
    }

    public Avaliacao find(Integer id) {
        Optional<Avaliacao> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Avaliacao.class.getName()));
    }

    public Avaliacao insert(Avaliacao obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Avaliacao update(Avaliacao obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public List<Avaliacao> findAll() {
        return repo.findAll();
    }

    public Page<Avaliacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public List<Avaliacao> findByEtapa(Integer idEtapa) {
        Optional<Etapa> etapa = etapaRepository.findById(idEtapa);
        return repo.findByEtapa(etapa);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }
}
