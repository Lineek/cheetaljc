package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.Avaliacao;
import com.cheetal.jornadaCandidato.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/avaliacao")
public class NotaResource {

    private final AvaliacaoService service;

    @Autowired
    public NotaResource(AvaliacaoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Avaliacao> find(@PathVariable Integer id) {
        Avaliacao obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Avaliacao>> findAll() {
        List<Avaliacao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/page", method=RequestMethod.GET)
    public ResponseEntity<Page<Avaliacao>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricao") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Avaliacao> list = service.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Avaliacao obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Avaliacao obj) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/etapa/{idEtapa}", method = RequestMethod.GET)
    public ResponseEntity<List<Avaliacao>> findAllByEtapa(@PathVariable Integer idEtapa) {
        List<Avaliacao> list = service.findByEtapa(idEtapa);
        return ResponseEntity.ok().body(list);
    }
}
