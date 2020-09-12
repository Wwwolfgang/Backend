package com.roshka.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	private String numero_doc;
	private String tipo_doc;
	private String nacionalidad;
	private String telefono;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cliente")
	@OrderBy("fechaAsignacion")
	private List<BolsaPuntos> bolsas = new ArrayList<>();

	@JsonManagedReference
	public List<BolsaPuntos> getBolsas() {
		return bolsas;
	}

	public void setBolsas(List<BolsaPuntos> bolsas) {
		this.bolsas = bolsas;
	}

	public String getNumero_doc() {
		return numero_doc;
	}

	public void setNumero_doc(String numero_doc) {
		this.numero_doc = numero_doc;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	private String email;
	
	@Column(name="create_at")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	private static final long serialVersionUID = 1L;

}
