package com.cheetal.jornadaCandidato.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class CalendarioEtapa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dataProva;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "sala_id")
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
