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
@Table(name="Amigo")
public class AmigoDto {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "socioid")
    private SocioDto socio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "publicoid")
    private PublicoDto publico;
    
    private Timestamp fecha;

	public AmigoDto() {
		super();
	}

	public AmigoDto(Long id, SocioDto socio, PublicoDto publico, Timestamp fecha) {
		super();
		this.id = id;
		this.socio = socio;
		this.publico = publico;
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

	public PublicoDto getPublico() {
		return publico;
	}

	public void setPublico(PublicoDto publico) {
		this.publico = publico;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "AmigoDto [id=" + id + ", socio=" + socio + ", publico=" + publico + ", fecha=" + fecha + "]";
	}
    
    
}
