package com.example.tsf.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sociobandera")
public class SocioBanderaDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idsocio")
    private SocioDto socio;

	@ManyToOne(optional = false)
    @JoinColumn(name = "banderaid")
    private PancartaDto pancarta;

	@ManyToOne(optional = false)
    @JoinColumn(name = "actividadid")
    private ActividadDto actividad;

//	@ManyToOne(optional = false)
//    @JoinColumn(name = "viajeid")
//    private ViajeDto viaje;
	
	private Timestamp fecha;

public SocioBanderaDto() {
	super();
}

public SocioBanderaDto(Long id, SocioDto socio, PancartaDto pancarta, ActividadDto actividad, Timestamp fecha) {
	super();
	this.id = id;
	this.socio = socio;
	this.pancarta = pancarta;
	this.actividad = actividad;
	this.fecha = fecha;
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

public PancartaDto getPancarta() {
	return pancarta;
}

public void setPancarta(PancartaDto pancarta) {
	this.pancarta = pancarta;
}

public ActividadDto getActividad() {
	return actividad;
}

public void setActividad(ActividadDto actividad) {
	this.actividad = actividad;
}

public Timestamp getFecha() {
	return fecha;
}

public void setFecha(Timestamp fecha) {
	this.fecha = fecha;
}

@Override
public String toString() {
	return "SocioBanderaDto [id=" + id + ", socio=" + socio + ", pancarta=" + pancarta + ", actividad=" + actividad
			+ ", fecha=" + fecha + "]";
}
	
	
}
