package com.cheetal.jornadaCandidato.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class CalendarioEtapa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Length(min = 17, max = 18, message = "O tamanho deve ser entre 17 e 18 caracteres")
    private Date dataProva;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
//    @NotEmpty(message = "Preenchimento obrigatório")
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "sala_id")
//    @NotEmpty(message = "Preenchimento obrigatório")
    private Sala sala;

    public CalendarioEtapa() {
    }

    public CalendarioEtapa(Integer id, Date dataProva, Etapa etapa, Sala sala) {
        this.id = id;
        this.dataProva = dataProva;
        this.etapa = etapa;
        this.sala = sala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarioEtapa that = (CalendarioEtapa) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
