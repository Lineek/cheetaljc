package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.CalendarioEtapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioEtapaRepository extends JpaRepository<CalendarioEtapa, Integer> {

}