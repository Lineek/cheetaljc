package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.Nota;
import com.cheetal.jornadaCandidato.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ota")
public class NotaResource {

    private final NotaService service;

    @Autowired
    public NotaResource(NotaService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Nota> find(@PathVariable Integer id) {
        Nota obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Nota>> findAll() {
        List<Nota> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/page", method=RequestMethod.GET)
    public ResponseEntity<Page<Nota>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "descricao") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Nota> list = service.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Nota obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Nota obj) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/avaliacao/{idAvaliacao}", method = RequestMethod.GET)
    public ResponseEntity<List<Nota>> findAllByAvaliacao(@PathVariable Integer idAvaliacao) {
        List<Nota> list = service.findByAvaliacao(idAvaliacao);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/avaliacao/{idVestibulando}", method = RequestMethod.GET)
    public ResponseEntity<List<Nota>> findAllByVestibulando(@PathVariable Integer idVestibulando) {
        List<Nota> list = service.findByVestibulando(idVestibulando);
        return ResponseEntity.ok().body(list);
    }
}
