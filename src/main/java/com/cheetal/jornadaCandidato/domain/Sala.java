package com.cheetal.jornadaCandidato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Integer capacidade;

    @JsonIgnore
    @OneToMany(mappedBy = "sala")
    private List<CalendarioEtapa> calendarioEtapas = new ArrayList<>();

    public Sala() {
    }

    public Sala(Integer id, String descricao, Integer capacidade) {
        this.id = id;
        this.descricao = descricao;
        this.capacidade = capacidade;
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

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
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
        Sala sala = (Sala) o;
        return Objects.equals(id, sala.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
