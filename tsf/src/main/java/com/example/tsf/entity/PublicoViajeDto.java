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
@Table(name = "Publicoviaje")
public class PublicoViajeDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "publicoid")
    private PublicoDto publico;

	@ManyToOne(optional = false)
    @JoinColumn(name = "viajeid")
    private ViajeDto viaje;
	
	private Boolean ispagadobus, istieneentrada, islistaespera, islistanegra; 
	private String comentarios; 
	private Timestamp fecha;
	
	public PublicoViajeDto() {
		super();
	}
	public PublicoViajeDto(Long id, PublicoDto publico, ViajeDto viaje, Boolean ispagadobus, Boolean istieneentrada,
			Boolean islistaespera, Boolean islistanegra, String comentarios, Timestamp fecha) {
		super();
		this.id = id;
		this.publico = publico;
		this.viaje = viaje;
		this.ispagadobus = ispagadobus;
		this.istieneentrada = istieneentrada;
		this.islistaespera = islistaespera;
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
	public PublicoDto getPublico() {
		return publico;
	}
	public void setPublico(PublicoDto publico) {
		this.publico = publico;
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
	public Boolean getIstieneentrada() {
		return istieneentrada;
	}
	public void setIstieneentrada(Boolean istieneentrada) {
		this.istieneentrada = istieneentrada;
	}
	public Boolean getIslistaespera() {
		return islistaespera;
	}
	public void setIslistaespera(Boolean islistaespera) {
		this.islistaespera = islistaespera;
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
		return "PublicoViajeDto [id=" + id + ", publico=" + publico + ", viaje=" + viaje + ", ispagadobus="
				+ ispagadobus + ", istieneentrada=" + istieneentrada + ", islistaespera=" + islistaespera
				+ ", islistanegra=" + islistanegra + ", comentarios=" + comentarios + ", fecha=" + fecha + "]";
	}
	
	
}
