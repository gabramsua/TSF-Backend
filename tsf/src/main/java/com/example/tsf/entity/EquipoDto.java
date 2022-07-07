package com.example.tsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Equipo")
public class EquipoDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre, estadio;
    private Integer distancia;

    @OneToOne(mappedBy = "equipo")
    private ViajeDto viaje;
    
	public EquipoDto() {}
    
	public EquipoDto(Long id, String nombre, String estadio, Integer distancia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estadio = estadio;
		this.distancia = distancia;
	}

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

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "EquipoDto [id=" + id + ", nombre=" + nombre + ", estadio=" + estadio + ", distancia=" + distancia + "]";
	}
	
}
