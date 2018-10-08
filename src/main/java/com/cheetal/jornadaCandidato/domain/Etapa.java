package com.cheetal.jornadaCandidato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Etapa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "processoSeletivo_id")
    private ProcessoSeletivo processoSeletivo;


    @JsonIgnore
    @OneToMany(mappedBy = "etapa")
    private List<CalendarioEtapa> calendarioEtapas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "etapa")
    private List<Vestibulando> vestibulandos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "etapa")
    private List<Avaliacao> avaliacaos = new ArrayList<>();

    public Etapa() {
    }

    public Etapa(Integer id, String descricao, ProcessoSeletivo processoSeletivo) {
        this.id = id;
        this.descricao = descricao;
        this.processoSeletivo = processoSeletivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProcessoSeletivo getProcessoSeletivo() {
        return processoSeletivo;
    }

    public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        this.processoSeletivo = processoSeletivo;
    }

    public List<CalendarioEtapa> getCalendarioEtapas() {
        return calendarioEtapas;
    }

    public void setCalendarioEtapas(List<CalendarioEtapa> calendarioEtapas) {
        this.calendarioEtapas = calendarioEtapas;
    }

    public List<Vestibulando> getVestibulandos() {
        return vestibulandos;
    }

    public void setVestibulandos(List<Vestibulando> vestibulandos) {
        this.vestibulandos = vestibulandos;
    }

    public List<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etapa etapa = (Etapa) o;
        return Objects.equals(id, etapa.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
