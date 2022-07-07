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
@Table(name = "Socioviaje")
public class SocioViajeDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "socioid")
    private SocioDto socio;

	@ManyToOne(optional = false)
    @JoinColumn(name = "viajeid")
    private ViajeDto viaje;
	
	private Boolean ispagadobus, isentradapedida, istieneentrada, isentradapagada,	islistanegra; 
	private String comentarios; 
	private Timestamp fecha;
	public SocioViajeDto() {
		super();
	}
	public SocioViajeDto(Long id, SocioDto socio, ViajeDto viaje, Boolean ispagadobus, Boolean isentradapedida,
			Boolean istieneentrada, Boolean isentradapagada, Boolean islistanegra, String comentarios,
			Timestamp fecha) {
		super();
		this.id = id;
		this.socio = socio;
		this.viaje = viaje;
		this.ispagadobus = ispagadobus;
		this.isentradapedida = isentradapedida;
		this.istieneentrada = istieneentrada;
		this.isentradapagada = isentradapagada;
		this.islistanegra = islistanegra;
		this.comentarios = comentarios;
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
	public ViajeDto getViaje() {
		return viaje;
	}
	public void setViaje(ViajeDto viaje) {
		this.viaje = viaje;
	}
	public Boolean getIspagadobus() {
		return ispagadobus;
	}
	public void setIspagadobus(Boolean ispagadobus) {
		this.ispagadobus = ispagadobus;
	}
	public Boolean getIsentradapedida() {
		return isentradapedida;
	}
	public void setIsentradapedida(Boolean isentradapedida) {
		this.isentradapedida = isentradapedida;
	}
	public Boolean getIstieneentrada() {
		return istieneentrada;
	}
	public void setIstieneentrada(Boolean istieneentrada) {
		this.istieneentrada = istieneentrada;
	}
	public Boolean getIsentradapagada() {
		return isentradapagada;
	}
	public void setIsentradapagada(Boolean isentradapagada) {
		this.isentradapagada = isentradapagada;
	}
	public Boolean getIslistanegra() {
		return islistanegra;
	}
	public void setIslistanegra(Boolean islistanegra) {
		this.islistanegra = islistanegra;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "SocioViajeDto [id=" + id + ", socio=" + socio + ", viaje=" + viaje + ", ispagadobus=" + ispagadobus
				+ ", isentradapedida=" + isentradapedida + ", istieneentrada=" + istieneentrada + ", isentradapagada="
				+ isentradapagada + ", islistanegra=" + islistanegra + ", comentarios=" + comentarios + ", fecha="
				+ fecha + "]";
	}
	
	
}
