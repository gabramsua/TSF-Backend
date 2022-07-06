package com.example.tsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pancarta")
public class PancartaDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre, color;

//    @Column(name="idfoto")
//    @OneToMany(targetEntity=FotoDto.class)
    @OneToOne
    @JoinColumn(name = "fotoid", updatable = true, nullable = true)
    private FotoDto foto;

	public PancartaDto() {
	}

	public PancartaDto(Long id, String nombre, String color, FotoDto foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.foto = foto;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public FotoDto getFoto() {
		return foto;
	}

	public void setFoto(FotoDto foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "PancartaDto [id=" + id + ", nombre=" + nombre + ", color=" + color + ", foto=" + foto + "]";
	}
	
	
}
