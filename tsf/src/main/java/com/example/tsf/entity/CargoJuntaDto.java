package com.example.tsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cargojunta")
public class CargoJuntaDto {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String puesto;

	public CargoJuntaDto() {
		super();
	}

	public CargoJuntaDto(Long id, String puesto) {
		super();
		this.id = id;
		this.puesto = puesto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "CargoJuntaDto [id=" + id + ", puesto=" + puesto + "]";
	}
    
    
}
