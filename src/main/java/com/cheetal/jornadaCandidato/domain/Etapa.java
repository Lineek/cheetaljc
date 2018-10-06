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
