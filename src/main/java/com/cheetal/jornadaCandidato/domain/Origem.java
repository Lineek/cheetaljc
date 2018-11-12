package com.cheetal.jornadaCandidato.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Origem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Length(min = 3, message = "O tamanho deve ser entre 3 e 120 caracteres")
    private String opcao;

    public Origem() {
    }

    public Origem(Integer id, String opcao) {
        this.id = id;
        this.opcao = opcao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Origem origem = (Origem) o;
        return Objects.equals(id, origem.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
