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
@Table(name="Bus")
public class BusDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "viajeid", updatable = true, nullable = true)
    private ViajeDto viaje;
    
    private String categoria, empresa;
    private Integer preciobus, preciosocio, preciopublico;

	public BusDto() {
		super();
	}
	public BusDto(Long id, ViajeDto viaje, String categoria, Integer preciobus, Integer preciosocio,
			Integer preciopublico, String empresa) {
		super();
		this.id = id;
		this.viaje = viaje;
		this.empresa = empresa;
		this.categoria = categoria;
		this.preciobus = preciobus;
		this.preciosocio = preciosocio;
		this.preciopublico = preciopublico;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ViajeDto getViaje() {
		return viaje;
	}
	public void setViaje(ViajeDto viaje) {
		this.viaje = viaje;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getPreciobus() {
		return preciobus;
	}
	public void setPreciobus(Integer preciobus) {
		this.preciobus = preciobus;
	}
	public Integer getPreciosocio() {
		return preciosocio;
	}
	public void setPreciosocio(Integer preciosocio) {
		this.preciosocio = preciosocio;
	}
	public Integer getPreciopublico() {
		return preciopublico;
	}
	public void setPreciopublico(Integer preciopublico) {
		this.preciopublico = preciopublico;
	}
	@Override
	public String toString() {
		return "BusDto [id=" + id + ", viaje=" + viaje + ", categoria=" + categoria + ", empresa=" + empresa
				+ ", preciobus=" + preciobus + ", preciosocio=" + preciosocio + ", preciopublico=" + preciopublico
				+ "]";
	}
    

}
