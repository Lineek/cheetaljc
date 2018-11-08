package com.cheetal.jornadaCandidato.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 6, message = "O tamanho deve ser entre 6 e 120 caracteres")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    @NotEmpty(message = "Preenchimento obrigatório")
    private Etapa etapa;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer notaMaxima;

    @NotEmpty(message = "Preenchimento obrigatório")
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
