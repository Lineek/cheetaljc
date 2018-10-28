package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.*;
import com.cheetal.jornadaCandidato.domain.enums.Escolaridade;
import com.cheetal.jornadaCandidato.domain.enums.Sexo;
import com.cheetal.jornadaCandidato.dto.PessoaDTO;
import com.cheetal.jornadaCandidato.dto.PessoaVestibulandoDTO;
import com.cheetal.jornadaCandidato.repositories.EnderecoRepository;
import com.cheetal.jornadaCandidato.repositories.OrigemRepository;
import com.cheetal.jornadaCandidato.repositories.PessoaRepository;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private OrigemRepository origemRepository;

    public PessoaService(PessoaRepository repo) {
        this.repo = repo;
    }

    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Etapa.class.getName()));
    }

    public Pessoa findByEmailAndSenha(String email, String senha) {
        Pessoa obj = repo.findByEmail(email);
        if (!(BCrypt.checkpw(senha, obj.getSenha()))) {
            throw new ObjectNotFoundException("Objeto não encontrado! Email: " + email + " Senha: " + senha + ", Tipo: " + Etapa.class.getName());
        }
        return obj;
    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    @Transactional
    public Pessoa insertVestibulando(Vestibulando obj) throws Exception {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.save(obj.getEndereco());
        Origem origem = origemRepository.getOne(obj.getOrigem().getId());
        origemRepository.save(obj.getOrigem());
        return obj;
    }

    public List<Pessoa> findAll() {
        return repo.findAll();
    }

    public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Vestibulando fromDTO(PessoaVestibulandoDTO objDto) {
        Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getCidade(), objDto.getEstado(),
                objDto.getNumero(), objDto.getComplemento(), objDto.getCep());
        Origem origem = origemRepository.getOne(objDto.getOrigem());
        Vestibulando vest = new Vestibulando(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getSenha(), origem,
                objDto.getTelefone(), objDto.getRg(), objDto.getCpf(), objDto.getNomeMae(), objDto.getNomePai(),
                Sexo.toEnum(objDto.getSexo()), endereco, Escolaridade.toEnum(objDto.getEscolaridade()),
                objDto.getEtapa(), objDto.getCalendarioEtapa());

        return vest;
    }

    public Administrador fromDTO() {
        return new Administrador();
    }

    private void updateData(Pessoa newObj, Pessoa obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}
