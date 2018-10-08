package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.Etapa;
import com.cheetal.jornadaCandidato.domain.Pessoa;
import com.cheetal.jornadaCandidato.domain.Vestibulando;
import com.cheetal.jornadaCandidato.dto.PessoaDTO;
import com.cheetal.jornadaCandidato.repositories.PessoaRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaRepository repo;

    public PessoaService(PessoaRepository repo) {
        this.repo = repo;
    }

    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Etapa.class.getName()));
    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public List<Pessoa> findAll() {
        return repo.findAll();
    }

    public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

//    public Vestibulando fromDTO(PessoaDTO objDto) {
//        return new Vestibulando(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getSenha());
//    }

    private void updateData(Pessoa newObj, Pessoa obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}
