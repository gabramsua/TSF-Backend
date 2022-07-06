package com.example.tsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Temporada")
public class TemporadaDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private Integer precioalta, preciorenovacion;
    
    public TemporadaDto() {}

	public TemporadaDto(Long id, String nombre, Integer precioalta, Integer preciorenovacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioalta = precioalta;
		this.preciorenovacion = preciorenovacion;
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

	public Integer getPrecioalta() {
		return precioalta;
	}

	public void setPrecioalta(Integer precioalta) {
		this.precioalta = precioalta;
	}

	public Integer getPreciorenovacion() {
		return preciorenovacion;
	}

	public void setPreciorenovacion(Integer preciorenovacion) {
		this.preciorenovacion = preciorenovacion;
	}

	@Override
	public String toString() {
		return "TemporadaDto [id=" + id + ", nombre=" + nombre + ", precioalta=" + precioalta + ", preciorenovacion="
				+ preciorenovacion + "]";
	}
    
    

}
