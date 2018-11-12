package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.CalendarioEtapa;
import com.cheetal.jornadaCandidato.domain.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalendarioEtapaRepository extends JpaRepository<CalendarioEtapa, Integer> {

    @Transactional(readOnly = true)
    List<CalendarioEtapa> findByEtapa(Optional<Etapa> etapa);
}