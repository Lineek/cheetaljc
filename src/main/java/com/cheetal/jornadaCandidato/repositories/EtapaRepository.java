package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Integer> {

}