package com.cheetal.jornadaCandidato;

import com.cheetal.jornadaCandidato.domain.Etapa;
import com.cheetal.jornadaCandidato.domain.ProcessoSeletivo;
import com.cheetal.jornadaCandidato.repositories.EtapaRepository;
import com.cheetal.jornadaCandidato.repositories.ProcessoSeletivoRepository;
import com.cheetal.jornadaCandidato.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JornadaCandidatoApplication implements CommandLineRunner {

    private final EtapaRepository etapaRepository;
    private final ProcessoSeletivoRepository processoSeletivoRepository;
    private final SalaRepository salaRepository;

    @Autowired
    public JornadaCandidatoApplication(EtapaRepository etapaRepository, ProcessoSeletivoRepository processoSeletivoRepository,
                                       SalaRepository salaRepository) {
        this.etapaRepository = etapaRepository;
        this.processoSeletivoRepository = processoSeletivoRepository;
        this.salaRepository = salaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JornadaCandidatoApplication.class, args);
    }

    public void run(String... args) {
        ProcessoSeletivo ps1 = new ProcessoSeletivo(null, "2018.2");
        ProcessoSeletivo ps2 = new ProcessoSeletivo(null, "2019.1");

        Etapa e1 = new Etapa(null, "Vestibular 1", ps1);
        Etapa e2 = new Etapa(null, "Final", ps1);

        ps1.getEtapas().addAll(Arrays.asList(e1, e2));

        processoSeletivoRepository.saveAll(Arrays.asList(ps1, ps2));
        etapaRepository.saveAll(Arrays.asList(e1, e2));
    }
}
