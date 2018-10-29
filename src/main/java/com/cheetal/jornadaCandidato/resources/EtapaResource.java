package com.cheetal.jornadaCandidato.resources;

import com.cheetal.jornadaCandidato.domain.Etapa;
import com.cheetal.jornadaCandidato.services.EtapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/etapa")
public class EtapaResource {

    private final EtapaService service;

    @Autowired
    public EtapaResource(EtapaService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Etapa> find(@PathVariable Integer id) {
        Etapa obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
