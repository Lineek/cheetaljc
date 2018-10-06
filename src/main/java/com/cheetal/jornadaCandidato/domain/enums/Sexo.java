package com.cheetal.jornadaCandidato.domain.enums;

public enum Sexo {
    FEMININO(1, "Feminino"),
    MASCULINO(2, "Masculino");

    private int cod;
    private String descricao;

    Sexo(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Sexo toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for (Sexo x : Sexo.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
