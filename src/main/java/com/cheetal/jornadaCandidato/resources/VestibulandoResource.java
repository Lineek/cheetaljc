package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.Pessoa;
import com.cheetal.jornadaCandidato.domain.Vestibulando;
import com.cheetal.jornadaCandidato.dto.PessoaVestibulandoDTO;
import com.cheetal.jornadaCandidato.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vestibulando")
public class VestibulandoResource {

    private final PessoaService service;

    @Autowired
    public VestibulandoResource(PessoaService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PessoaVestibulandoDTO objDto) {
        Pessoa obj = service.fromDTO(objDto);
        obj = service.insertVestibulando((Vestibulando) obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/etapas/{id_etapa}", method = RequestMethod.GET)
    public ResponseEntity<List<Vestibulando>> findAllByEtapa(@PathVariable Integer id_etapa) {
        List<Vestibulando> list = service.findAllByEtapa(id_etapa);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/calendario/{id_calendario_etapa}", method = RequestMethod.GET)
    public ResponseEntity<List<Vestibulando>> findAllByCalendario(@PathVariable Integer id_calendario_etapa) {
        List<Vestibulando> list = service.findAllByCalendarioEtapa(id_calendario_etapa);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody PessoaVestibulandoDTO obj) {
        obj.setId(id);
        Vestibulando objDto = service.fromDtoWithSenhaByspass(obj);
        service.update(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/mudancaEtapa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateMudancaEtapa(@PathVariable Integer id) {
        Vestibulando obj = service.findVestib(1);
        obj.setMudancaEtapa(!obj.getMudancaEtapa());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
