package com.example.tsf.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Actividad")
public class ActividadDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "temporadaid", updatable = true, nullable = true)
    private TemporadaDto temporada;
    
    @OneToOne
    @JoinColumn(name = "viajeid", updatable = true, nullable = true)
    private ViajeDto viaje;
    
    private String nombre, premios;
    private Double coste;
    private Integer preciosocio, preciopublico;
    private Timestamp fecha;
    

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private Set<ActividadSocioDto> actividadsocio = new HashSet<>();

    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private Set<SocioBanderaDto> sociobandera = new HashSet<>();
    
	public ActividadDto() {
		super();
	}
	public ActividadDto(Long id, TemporadaDto temporada, ViajeDto viaje, String nombre, String premios, Double coste,
			Integer preciosocio, Integer preciopublico, Timestamp fecha) {
		super();
		this.id = id;
		this.temporada = temporada;
		this.viaje = viaje;
		this.nombre = nombre;
		this.premios = premios;
		this.coste = coste;
		this.preciosocio = preciosocio;
		this.preciopublico = preciopublico;
		this.fecha = fecha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TemporadaDto getTemporada() {
		return temporada;
	}
	public void setTemporada(TemporadaDto temporada) {
		this.temporada = temporada;
	}
	public ViajeDto getViaje() {
		return viaje;
	}
	public void setViaje(ViajeDto viaje) {
		this.viaje = viaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPremios() {
		return premios;
	}
	public void setPremios(String premios) {
		this.premios = premios;
	}
	public Double getCoste() {
		return coste;
	}
	public void setCoste(Double coste) {
		this.coste = coste;
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
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "ActividadDto [id=" + id + ", temporada=" + temporada + ", viaje=" + viaje + ", nombre=" + nombre
				+ ", premios=" + premios + ", coste=" + coste + ", preciosocio=" + preciosocio + ", preciopublico="
				+ preciopublico + ", fecha=" + fecha + "]";
	}
    
    
}
