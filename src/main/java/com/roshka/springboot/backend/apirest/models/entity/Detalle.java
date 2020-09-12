package com.roshka.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "detalles")
public class Detalle implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cabecera_id")
    private Cabecera cabecera;

    private Double puntosUtilizados;

    @ManyToOne
    @JoinColumn(name = "bolsa_id")
    private BolsaPuntos bolsaPuntos;

    @Column(name="create_at")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }

    public Double getPuntosUtilizados() {
        return puntosUtilizados;
    }

    public void setPuntosUtilizados(Double puntosUtilizados) {
        this.puntosUtilizados = puntosUtilizados;
    }

    public BolsaPuntos getBolsaPuntos() {
        return bolsaPuntos;
    }

    public void setBolsaPuntos(BolsaPuntos bolsaPuntos) {
        this.bolsaPuntos = bolsaPuntos;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    private static final long serialVersionUID = 1L;
}
