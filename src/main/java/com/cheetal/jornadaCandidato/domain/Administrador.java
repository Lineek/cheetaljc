package com.cheetal.jornadaCandidato.domain;

import javax.persistence.Entity;

@Entity
public class Administrador extends Pessoa {
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
