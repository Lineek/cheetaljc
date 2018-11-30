package com.cheetal.jornadaCandidato.repositories;

import com.cheetal.jornadaCandidato.domain.Avaliacao;
import com.cheetal.jornadaCandidato.domain.Nota;
import com.cheetal.jornadaCandidato.domain.Vestibulando;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    @Transactional(readOnly = true)
    List<Nota> findByVestibulando(Optional<Vestibulando> vestibulando);

    @Transactional(readOnly = true)
    List<Nota> findByAvaliacao(Optional<Avaliacao> avaliacao);
}