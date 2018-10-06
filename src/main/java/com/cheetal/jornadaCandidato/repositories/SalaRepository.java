package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}