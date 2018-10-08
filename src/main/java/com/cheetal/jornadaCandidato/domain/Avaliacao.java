package com.cheetal.jornadaCandidato.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    private Integer notaMaxima;
    private Double peso;

    public Avaliacao() {
    }

    public Avaliacao(Integer id, String descricao, Etapa etapa, Integer notaMaxima, Double peso) {
        this.id = id;
        this.descricao = descricao;
        this.etapa = etapa;
        this.notaMaxima = notaMaxima;
        this.peso = peso;
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
    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Integer getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(Integer notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(id, avaliacao.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
