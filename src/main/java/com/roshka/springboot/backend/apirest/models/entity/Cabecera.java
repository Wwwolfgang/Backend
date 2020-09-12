package com.roshka.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cabeceras")
public class Cabecera implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Double puntosUtilizados;

    @Column(name = "descripcion_puntos")
    private String descripcionPuntos;

    @Column(name="fecha")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fecha;

    @Column(name="create_at")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getPuntosUtilizados() {
        return puntosUtilizados;
    }

    public void setPuntosUtilizados(Double puntosUtilizados) {
        this.puntosUtilizados = puntosUtilizados;
    }

    public String getDescripcionPuntos() {
        return descripcionPuntos;
    }

    public void setDescripcionPuntos(String descripcionPuntos) {
        this.descripcionPuntos = descripcionPuntos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    private static final long serialVersionUID = 1L;
}
