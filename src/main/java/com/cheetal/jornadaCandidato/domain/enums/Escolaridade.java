package com.cheetal.jornadaCandidato.domain.enums;

public enum Escolaridade {
    ENSINO_MEDIO_INCOMPLETO(1, "Ensino Médio incompleto"),
    ENSINO_MEDIO_COMPLETO(2, "Ensino Médio completo"),
    ENSINO_SUPERIOR_INCOMPLETO(3, "Ensino Superior incompleto"),
    ENSINO_SUPERIOR_COMPLETO(4, "Ensino Superior completo");


    private int cod;
    private String descricao;

    Escolaridade(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Escolaridade toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for (Escolaridade x : Escolaridade.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
