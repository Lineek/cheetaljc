package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.CalendarioEtapa;
import com.cheetal.jornadaCandidato.domain.Etapa;
import com.cheetal.jornadaCandidato.domain.Vestibulando;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VestibulandoRepository extends JpaRepository<Vestibulando, Integer>{

    @Transactional(readOnly = true)
    Vestibulando findByEtapa(Etapa etapa);

    @Transactional(readOnly = true)
    Vestibulando findByCalendarioEtapa(CalendarioEtapa calendarioEtapa);
}