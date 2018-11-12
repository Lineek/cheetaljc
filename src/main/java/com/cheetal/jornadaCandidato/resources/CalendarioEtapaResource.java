package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.CalendarioEtapa;
import com.cheetal.jornadaCandidato.services.CalendarioEtapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/calendarioetapa")
public class CalendarioEtapaResource {

    private final CalendarioEtapaService service;

    @Autowired
    public CalendarioEtapaResource(CalendarioEtapaService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CalendarioEtapa> find(@PathVariable Integer id) {
        CalendarioEtapa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<CalendarioEtapa>> findAll() {
        List<CalendarioEtapa> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/page", method=RequestMethod.GET)
    public ResponseEntity<Page<CalendarioEtapa>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "dataProva") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<CalendarioEtapa> list = service.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CalendarioEtapa obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/etapa/{idEtapa}", method = RequestMethod.GET)
    public ResponseEntity<List<CalendarioEtapa>> findAllByEtapa(@PathVariable Integer idEtapa) {
        List<CalendarioEtapa> list = service.findByEtapa(idEtapa);
        return ResponseEntity.ok().body(list);
    }
}
