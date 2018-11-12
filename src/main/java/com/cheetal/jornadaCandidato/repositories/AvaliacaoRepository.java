package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.Avaliacao;
import com.cheetal.jornadaCandidato.domain.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

    @Transactional(readOnly = true)
    List<Avaliacao> findByEtapa(Optional<Etapa> etapa);
}