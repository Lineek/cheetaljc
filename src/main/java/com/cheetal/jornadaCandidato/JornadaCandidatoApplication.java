package com.cheetal.jornadaCandidato;

import com.cheetal.jornadaCandidato.domain.*;
import com.cheetal.jornadaCandidato.domain.enums.Escolaridade;
import com.cheetal.jornadaCandidato.domain.enums.Sexo;
import com.cheetal.jornadaCandidato.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class JornadaCandidatoApplication implements CommandLineRunner {

    private final EtapaRepository etapaRepository;
    private final ProcessoSeletivoRepository processoSeletivoRepository;
    private final SalaRepository salaRepository;
    private final CalendarioEtapaRepository calendarioEtapaRepository;
    private final EnderecoRepository enderecoRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private OrigemRepository origemRepository;

    @Autowired
    public JornadaCandidatoApplication(EtapaRepository etapaRepository, ProcessoSeletivoRepository processoSeletivoRepository,
                                       SalaRepository salaRepository, CalendarioEtapaRepository calendarioEtapaRepository,
                                       EnderecoRepository enderecoRepository, AvaliacaoRepository avaliacaoRepository) {
        this.etapaRepository = etapaRepository;
        this.processoSeletivoRepository = processoSeletivoRepository;
        this.salaRepository = salaRepository;
        this.calendarioEtapaRepository = calendarioEtapaRepository;
        this.enderecoRepository = enderecoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JornadaCandidatoApplication.class, args);
    }

    public void run(String... args) throws Exception {
        ProcessoSeletivo ps1 = new ProcessoSeletivo(null, "2018.2");
        ProcessoSeletivo ps2 = new ProcessoSeletivo(null, "2019.1");

        Etapa e1 = new Etapa(null, "Vestibular 1", ps1);
        Etapa e2 = new Etapa(null, "Final", ps1);

        ps1.getEtapas().addAll(Arrays.asList(e1, e2));

        processoSeletivoRepository.saveAll(Arrays.asList(ps1, ps2));
        etapaRepository.saveAll(Arrays.asList(e1, e2));

        Sala s1 = new Sala(null, "Digital", 40, 2, 3);
        Sala s2 = new Sala(null, "Digital", 60, 1, 3);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        CalendarioEtapa ce1 = new CalendarioEtapa(null, sdf.parse("01/01/2019 00:00"), e1, s1);
        CalendarioEtapa ce2 = new CalendarioEtapa(null, sdf.parse("01/01/2019 00:00"), e1, s2);

        s1.getCalendarioEtapas().addAll(Arrays.asList(ce1));
        e1.getCalendarioEtapas().addAll(Arrays.asList(ce1, ce2));

        salaRepository.saveAll(Arrays.asList(s1, s2));
        calendarioEtapaRepository.saveAll(Arrays.asList(ce1, ce2));

        Endereco end1 = new Endereco(null, "Rua Lua", "São Paulo", "SP", "42", null, "02145221");

        enderecoRepository.save(end1);

        Avaliacao av1 = new Avaliacao(null, "Comportamental", e1, 100, 0.6);
        Avaliacao av2 = new Avaliacao(null, "Interação", e1, 100, 0.4);

        e1.getAvaliacaos().addAll(Arrays.asList(av1,av2));

        avaliacaoRepository.saveAll(Arrays.asList(av1, av2));

        Origem origem = new Origem(null, "Facebook");
        Pessoa vest1 = new Vestibulando(null, "José Maria", "jmaria@hot.com", "111as2", origem,
                998989888, "49123058204", "58230490423", "Maria", "José", Sexo.MASCULINO, null,
                end1, Escolaridade.ENSINO_MEDIO_COMPLETO, null, null);

        origemRepository.save(origem);

        pessoaRepository.save(vest1);
    }
}

