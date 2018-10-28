package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Transactional(readOnly = true)
    Pessoa findByEmail(String email);
}