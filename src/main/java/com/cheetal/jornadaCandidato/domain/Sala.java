package com.cheetal.jornadaCandidato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2, message = "O tamanho deve ser entre 2 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer capacidade;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer numero;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer andar;

    @JsonIgnore
    @OneToMany(mappedBy = "sala")
    private List<CalendarioEtapa> calendarioEtapas = new ArrayList<>();

    public Sala() {
    }

    public Sala(Integer id, String nome, Integer capacidade, Integer numero, Integer andar) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.numero = numero;
        this.andar = andar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
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
