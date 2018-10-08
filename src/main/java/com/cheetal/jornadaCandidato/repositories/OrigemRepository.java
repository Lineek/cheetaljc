package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.Origem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigemRepository extends JpaRepository<Origem, Integer> {

}