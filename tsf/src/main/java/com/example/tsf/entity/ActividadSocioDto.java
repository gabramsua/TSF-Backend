package com.example.tsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Actividadsocio")
public class ActividadSocioDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "socioid")
    private SocioDto socio;

	@ManyToOne(optional = false)
    @JoinColumn(name = "actividadid")
    private ActividadDto actividad;
	
	private String resultado, comentarios;

	public ActividadSocioDto() {
		super();
	}

	public ActividadSocioDto(Long id, SocioDto socio, ActividadDto actividad, String resultado, String comentarios) {
		super();
		this.id = id;
		this.socio = socio;
		this.actividad = actividad;
		this.resultado = resultado;
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SocioDto getSocio() {
		return socio;
	}

	public void setSocio(SocioDto socio) {
		this.socio = socio;
	}

	public ActividadDto getActividad() {
		return actividad;
	}

	public void setActividad(ActividadDto actividad) {
		this.actividad = actividad;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "ActividadSocioDto [id=" + id + ", socio=" + socio + ", actividad=" + actividad + ", resultado="
				+ resultado + ", comentarios=" + comentarios + "]";
	}
	
	

}
