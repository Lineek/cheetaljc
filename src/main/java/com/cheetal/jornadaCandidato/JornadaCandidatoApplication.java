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
import java.util.ArrayList;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        ProcessoSeletivo ps1 = new ProcessoSeletivo(null, sdf.parse("01/08/2018 00:00"), sdf.parse("01/01/2019 00:00"), "Processo Seletivo Turma 1 2019");

        Etapa e2 = new Etapa(null, "Prova de Conhecimentos Gerais", ps1);
        Etapa e3 = new Etapa(null, "Dinâmica", ps1);
        Etapa e4 = new Etapa(null, "Matrícula", ps1);

        ps1.getEtapas().addAll(Arrays.asList(e2, e3, e4));

        processoSeletivoRepository.saveAll(Arrays.asList(ps1));
        etapaRepository.saveAll(Arrays.asList(e2, e3, e4));

        Sala s1 = new Sala(null, "Digital", 60, 1, 3);
        Sala s2 = new Sala(null, "Digital", 40, 2, 3);
        Sala s3 = new Sala(null, "Digital", 60, 1, 4);

        CalendarioEtapa ce1 = new CalendarioEtapa(null, sdf.parse("20/12/2018 00:00"), e2, s1);
        CalendarioEtapa ce2 = new CalendarioEtapa(null, sdf.parse("01/01/2019 00:00"), e3, s2);
        CalendarioEtapa ce3 = new CalendarioEtapa(null, sdf.parse("14/12/2018 00:00"), e4, s2);

        e2.getCalendarioEtapas().addAll(Arrays.asList(ce1));
        e3.getCalendarioEtapas().addAll(Arrays.asList(ce2));
        e4.getCalendarioEtapas().addAll(Arrays.asList(ce3));

        salaRepository.saveAll(Arrays.asList(s1, s2, s3));
        calendarioEtapaRepository.saveAll(Arrays.asList(ce1, ce2));

        Endereco end1 = new Endereco(null, "Rua Lua", "São Paulo", "SP", "42", null, "02145221");

        enderecoRepository.save(end1);

        Avaliacao av1 = new Avaliacao(null, "Comportamental", "Avaliação de comportamento onde é atribuido nota de acordo" +
                " com vários aspéctos socioemocionais.", e3, 100, 0.6);
        Avaliacao av2 = new Avaliacao(null, "Interação", "Nota atribuída a pessoa pela sua forma de inte" +
                "ragir com o grupo todo da Dinâmica", e3, 100, 0.4);
        Avaliacao av3 = new Avaliacao(null, "Prova Geral","Prova de multipla escolha contendo as segui" +
                "ntes matérias: Português, Matemática, História do Brasil, História Geral e Conhecimentos Gerais", e2,
                100, 0.4);
        Avaliacao av4 = new Avaliacao(null, "Entrega de Documentos", "Rua Haddock Lobo, 595. Falar com" +
                " a secretaria", e4, 0, 1.0);

        e2.getAvaliacaos().add(av3);
        e3.getAvaliacaos().addAll(Arrays.asList(av1, av2));
        e4.getAvaliacaos().add(av4);

        avaliacaoRepository.saveAll(Arrays.asList(av1, av2, av3, av4));

        Origem origem = new Origem(null, "Facebook");
        Origem origem2 = new Origem(null, "Eventos");
        Origem origem3 = new Origem(null, "Google");
        Origem origem4 = new Origem(null, "Proa");
        Origem origem5 = new Origem(null, "ETEC");
        Origem origem6 = new Origem(null, "Instagram");
        Origem origem7 = new Origem(null, "Indicação de amigos/familiares");
        Origem origem8 = new Origem(null, "Outros");
        Pessoa vest1 = new Vestibulando(null, "José Maria", "jmaria@hot.com", "111as2", origem,
                998989888, "49123058204", "58230490423", "Maria", "José", Sexo.MASCULINO,
                null, end1, Escolaridade.ENSINO_MEDIO_COMPLETO, null, null);

        Pessoa admin = new Administrador(null, "Vera", "vera@hot.com", "vera", "Diretora");

        origemRepository.saveAll(Arrays.asList(origem, origem2, origem3, origem4, origem5, origem6, origem7, origem8));

        pessoaRepository.save(vest1);
        pessoaRepository.save(admin);
    }
}

