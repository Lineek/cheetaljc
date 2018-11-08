package com.cheetal.jornadaCandidato.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Administrador extends Pessoa {

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2, message = "O tamanho deve ser entre 2 e 120 caracteres")
    private String cargo;

    public Administrador() {
    }

    public Administrador(Integer id, String nome, String email, String senha, String cargo) {
        super(id, nome, email, senha);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
