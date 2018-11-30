package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.Avaliacao;
import com.cheetal.jornadaCandidato.domain.Nota;
import com.cheetal.jornadaCandidato.domain.Vestibulando;
import com.cheetal.jornadaCandidato.repositories.AvaliacaoRepository;
import com.cheetal.jornadaCandidato.repositories.NotaRepository;
import com.cheetal.jornadaCandidato.repositories.VestibulandoRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    private final NotaRepository repo;

    @Autowired
    private VestibulandoRepository vestibulandoRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    public NotaService(NotaRepository repo) {
        this.repo = repo;
    }

    public Nota find(Integer id) {
        Optional<Nota> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Nota.class.getName()));
    }

    public Nota insert(Nota obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Nota update(Nota obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public List<Nota> findAll() {
        return repo.findAll();
    }

    public Page<Nota> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public List<Nota> findByVestibulando(Integer idVestibulando) {
        Optional<Vestibulando> vestibulando = vestibulandoRepository.findById(idVestibulando);
        return repo.findByVestibulando(vestibulando);
    }

    public List<Nota> findByAvaliacao(Integer idAvaliacao) {
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(idAvaliacao);
        return repo.findByAvaliacao(avaliacao);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }
}
