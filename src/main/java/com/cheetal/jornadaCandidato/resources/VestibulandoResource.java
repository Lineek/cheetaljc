package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.Endereco;
import com.cheetal.jornadaCandidato.domain.Pessoa;
import com.cheetal.jornadaCandidato.domain.Vestibulando;
import com.cheetal.jornadaCandidato.dto.PessoaVestibulandoDTO;
import com.cheetal.jornadaCandidato.repositories.PessoaRepository;
import com.cheetal.jornadaCandidato.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/vestibulando")
public class VestibulandoResource {

    @Autowired
    private PessoaService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PessoaVestibulandoDTO objDto) {
        Pessoa obj = service.fromDTO(objDto);
        obj = service.insertVestibulando((Vestibulando) obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
