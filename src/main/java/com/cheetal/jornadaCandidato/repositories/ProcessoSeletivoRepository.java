package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.ProcessoSeletivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Integer> {

}