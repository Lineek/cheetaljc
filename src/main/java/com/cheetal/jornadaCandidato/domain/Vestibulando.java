package com.cheetal.jornadaCandidato.domain;


import com.cheetal.jornadaCandidato.domain.enums.Escolaridade;
import com.cheetal.jornadaCandidato.domain.enums.Sexo;

import javax.persistence.*;

@Entity
public class Vestibulando extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "origem_id")
    private Origem origem;
    private Integer telefone;
    private String rg;
    private String cpf;
    private String nomeMae;
    private String nomePai;
    private Integer sexo;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    private Integer escolaridade;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "caledarioEtapa_id")
    private CalendarioEtapa calendarioEtapa;

    public Vestibulando() {
    }

    public Vestibulando(Integer id, String nome, String email, String senha, Origem origem, Integer telefone, String rg, String cpf, String nomeMae, String nomePai, Sexo sexo, Endereco endereco, Escolaridade escolaridade, Etapa etapa, CalendarioEtapa calendarioEtapa) {
        super(id, nome, email, senha);
        this.origem = origem;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.sexo = sexo.getCod();
        this.endereco = endereco;
        this.escolaridade = escolaridade.getCod();
        this.etapa = etapa;
        this.calendarioEtapa = calendarioEtapa;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Sexo getSexo() {
        return Sexo.toEnum(sexo);
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo.getCod();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Escolaridade getEscolaridade() {
        return Escolaridade.toEnum(escolaridade);
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade.getCod();
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public CalendarioEtapa getCalendarioEtapa() {
        return calendarioEtapa;
    }

    public void setCalendarioEtapa(CalendarioEtapa calendarioEtapa) {
        this.calendarioEtapa = calendarioEtapa;
    }
}
