package com.cheetal.jornadaCandidato.services;

import com.cheetal.jornadaCandidato.domain.*;
import com.cheetal.jornadaCandidato.domain.enums.Escolaridade;
import com.cheetal.jornadaCandidato.domain.enums.Sexo;
import com.cheetal.jornadaCandidato.dto.PessoaVestibulandoDTO;
import com.cheetal.jornadaCandidato.repositories.*;
import com.cheetal.jornadaCandidato.services.exception.ObjectNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository repo;

    private final EnderecoRepository enderecoRepository;

    private final OrigemRepository origemRepository;

    private final VestibulandoRepository vestibulandoRepository;

    private final EtapaRepository etapaRepository;

    private final CalendarioEtapaRepository calendarioEtapaRepository;

    @Autowired
    public PessoaService(PessoaRepository repo, EnderecoRepository enderecoRepository, OrigemRepository origemRepository, VestibulandoRepository vestibulandoRepository, EtapaRepository etapaRepository, CalendarioEtapaRepository calendarioEtapaRepository) {
        this.repo = repo;
        this.enderecoRepository = enderecoRepository;
        this.origemRepository = origemRepository;
        this.vestibulandoRepository = vestibulandoRepository;
        this.etapaRepository = etapaRepository;
        this.calendarioEtapaRepository = calendarioEtapaRepository;
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
    public Pessoa insertVestibulando(Vestibulando obj) {
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

    public List<Vestibulando> findAllByEtapa(Integer idEtapa) {
        Optional<Etapa> etapa = etapaRepository.findById(idEtapa);
        return vestibulandoRepository.findByEtapa(etapa);
    }

    public List<Vestibulando> findAllByCalendarioEtapa(Integer idCalEtapa) {
        Optional<CalendarioEtapa> calEtapa = calendarioEtapaRepository.findById(idCalEtapa);
        return vestibulandoRepository.findByCalendarioEtapa(calEtapa);
    }

    public Vestibulando fromDTO(PessoaVestibulandoDTO objDto) {
        Endereco endereco = new Endereco(null, objDto.getLogradouro(), objDto.getCidade(), objDto.getEstado(),
                objDto.getNumero(), objDto.getComplemento(), objDto.getCep());
        Origem origem = origemRepository.getOne(objDto.getOrigem());
        return new Vestibulando(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getSenha(), origem,
                objDto.getTelefone(), objDto.getRg(), objDto.getCpf(), objDto.getNomeMae(), objDto.getNomePai(),
                Sexo.toEnum(objDto.getSexo()), objDto.getMudancaEtapa(), endereco, Escolaridade.toEnum(objDto.getEscolaridade()),
                objDto.getEtapa(), objDto.getCalendarioEtapa());
    }

    public Administrador fromDTO() {
        return new Administrador();
    }

    public Vestibulando update(Vestibulando obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        Pessoa obj = find(id);
        repo.deleteById(id);
    }

    private void updateData(Pessoa newObj, Pessoa obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}
