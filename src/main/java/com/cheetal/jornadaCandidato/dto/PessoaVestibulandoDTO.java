package com.cheetal.jornadaCandidato.dto;

import com.cheetal.jornadaCandidato.domain.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class PessoaVestibulandoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String senha;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Origem origem;
    private Integer telefone;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String rg;

    @NotEmpty(message = "Preenchimento obrigatório")
    @CPF
    private String cpf;
    private String nomeMae;
    private String nomePai;
    private Integer sexo;
    private Endereco endereco;
    private Integer escolaridade;
    private Etapa etapa;
    private CalendarioEtapa calendarioEtapa;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String logradouro;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String cidade;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String estado;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String numero;
    private String complemento;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String cep;

    public PessoaVestibulandoDTO() {
    }

    public PessoaVestibulandoDTO(Vestibulando obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.origem = origem;
        this.telefone = telefone;
        this.rg = rg;
        this.sexo = sexo;
        this.calendarioEtapa = calendarioEtapa;
        this.cpf = cpf;
        this.email = email;
        this.escolaridade = escolaridade;
        this.etapa = etapa;
        this. endereco = endereco;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Integer escolaridade) {
        this.escolaridade = escolaridade;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
