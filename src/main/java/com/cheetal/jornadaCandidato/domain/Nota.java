package com.cheetal.jornadaCandidato.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float nota;

    @ManyToOne
    @JoinColumn(name = "avaliacao_id")
    private Avaliacao avaliacao;

    @ManyToOne
    @JoinColumn(name = "vestibulando_id")
    private Vestibulando vestibulando;

    public Nota() {}

    public Nota(Integer id, Float nota, Avaliacao avaliacao, Vestibulando vestibulando) {
        this.id = id;
        this.nota = nota;
        this.avaliacao = avaliacao;
        this.vestibulando = vestibulando;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Vestibulando getVestibulando() {
        return vestibulando;
    }

    public void setVestibulando(Vestibulando vestibulando) {
        this.vestibulando = vestibulando;
    }
}
