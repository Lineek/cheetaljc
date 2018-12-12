package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.Pessoa;
import com.cheetal.jornadaCandidato.dto.PessoaDTO;
import com.cheetal.jornadaCandidato.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    private final PessoaService service;

    @Autowired
    public PessoaResource(PessoaService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> find(@PathVariable Integer id) {
        Pessoa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/validacao", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> find(@RequestParam String email, @RequestParam String senha) {
        Pessoa obj = service.findByEmailAndSenha(email, senha);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> list = service.findAll();
//        List<PessoaDTO> listDto = list.stream().map(PessoaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/page", method=RequestMethod.GET)
    public ResponseEntity<Page<PessoaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Pessoa> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<PessoaDTO> listDto = list.map(PessoaDTO::new);
        return ResponseEntity.ok().body(listDto);
    }
}
