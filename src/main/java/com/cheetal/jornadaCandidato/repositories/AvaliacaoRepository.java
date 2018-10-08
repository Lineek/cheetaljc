package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

}