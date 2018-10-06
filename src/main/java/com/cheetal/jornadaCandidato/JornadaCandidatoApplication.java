package com.cheetal.jornadaCandidato;

import com.cheetal.jornadaCandidato.domain.*;
import com.cheetal.jornadaCandidato.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class JornadaCandidatoApplication implements CommandLineRunner {

    private final EtapaRepository etapaRepository;
    private final ProcessoSeletivoRepository processoSeletivoRepository;
    private final SalaRepository salaRepository;
    private final CalendarioEtapaRepository calendarioEtapaRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public JornadaCandidatoApplication(EtapaRepository etapaRepository, ProcessoSeletivoRepository processoSeletivoRepository,
                                       SalaRepository salaRepository, CalendarioEtapaRepository calendarioEtapaRepository,
                                       EnderecoRepository enderecoRepository) {
        this.etapaRepository = etapaRepository;
        this.processoSeletivoRepository = processoSeletivoRepository;
        this.salaRepository = salaRepository;
        this.calendarioEtapaRepository = calendarioEtapaRepository;
        this.enderecoRepository = enderecoRepository;
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

        Sala s1 = new Sala(null, "3 Andar, Sala 1", 40);
        Sala s2 = new Sala(null, "3 Andar, Sala 2", 60);

        CalendarioEtapa ce1 = new CalendarioEtapa(null, new Date(2019, 1, 1), e1, s1);
        CalendarioEtapa ce2 = new CalendarioEtapa(null, new Date(2019, 1, 1), e1, s2);

        s1.getCalendarioEtapas().addAll(Arrays.asList(ce1));
        e1.getCalendarioEtapas().addAll(Arrays.asList(ce1, ce2));

        salaRepository.saveAll(Arrays.asList(s1, s2));
        calendarioEtapaRepository.saveAll(Arrays.asList(ce1, ce2));

        Endereco end1 = new Endereco(null, "Rua Lua", "São Paulo", "SP", "42", null, "02145221");

        enderecoRepository.save(end1);
    }
}
