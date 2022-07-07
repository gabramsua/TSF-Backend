package com.example.tsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Competicion")
public class CompeticionDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre, ronda;
    // TODO: Revisar esto de la ronda porque no cuadra bien...

	public CompeticionDto() {}

	public CompeticionDto(Long id, String nombre, String ronda) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ronda = ronda;
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

	public String getRonda() {
		return ronda;
	}

	public void setRonda(String ronda) {
		this.ronda = ronda;
	}

	@Override
	public String toString() {
		return "CompeticionDto [id=" + id + ", nombre=" + nombre + ", ronda=" + ronda + "]";
	}
    
    

}
