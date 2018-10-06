package com.cheetal.jornadaCandidato.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = getSenhaHash(senha.getBytes(), "SHA-224");
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
        this.senha = getSenhaHash(senha.getBytes(), "SHA-224");
    }

    // Algorithm can be: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512
    private static String getSenhaHash(byte[] inputByte, String algorithm) {
        String hashValue = "";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(inputByte);

            byte[] digestBytes = md.digest();
            hashValue = DatatypeConverter.printHexBinary(digestBytes).toLowerCase();
        } catch (Exception e) {

        }
        return hashValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
