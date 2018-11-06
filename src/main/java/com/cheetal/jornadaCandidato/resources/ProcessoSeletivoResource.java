package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.ProcessoSeletivo;
import com.cheetal.jornadaCandidato.services.ProcessoSeletivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/processoseletivo")
public class ProcessoSeletivoResource {

    private final ProcessoSeletivoService service;

    @Autowired
    public ProcessoSeletivoResource(ProcessoSeletivoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProcessoSeletivo> find(@PathVariable Integer id) {
        ProcessoSeletivo obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ProcessoSeletivo obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
