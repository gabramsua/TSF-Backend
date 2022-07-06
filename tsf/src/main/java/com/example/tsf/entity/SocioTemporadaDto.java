package com.example.tsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sociotemporada")
public class SocioTemporadaDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idsocio")
    private SocioDto socio;

	@ManyToOne(optional = false)
    @JoinColumn(name = "idtemporada")
    private TemporadaDto temporada;
    
    private Boolean iscuotapagada;
    private Integer numsfc, numtsf;
    
    @Enumerated(EnumType.STRING)
//    @Column(name = "metodopago")
    private MetodoPago metodopago;
    

    public SocioTemporadaDto() {
	}


	@Override
	public String toString() {
		return "SocioTemporadaDto [id=" + id + ", socio=" + socio.toString() + ", temporada=" + temporada.toString() + ", iscuotapagada="
				+ iscuotapagada + ", numsfc=" + numsfc + ", numtsf=" + numtsf + ", metodopago=" + metodopago + "]";
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


	public TemporadaDto getTemporada() {
		return temporada;
	}


	public void setTemporada(TemporadaDto temporada) {
		this.temporada = temporada;
	}


	public Boolean getIscuotapagada() {
		return iscuotapagada;
	}


	public void setIscuotapagada(Boolean iscuotapagada) {
		this.iscuotapagada = iscuotapagada;
	}


	public Integer getNumsfc() {
		return numsfc;
	}


	public void setNumsfc(Integer numsfc) {
		this.numsfc = numsfc;
	}


	public Integer getNumtsf() {
		return numtsf;
	}


	public void setNumtsf(Integer numtsf) {
		this.numtsf = numtsf;
	}


	public MetodoPago getMetodopago() {
		return metodopago;
	}


	public void setMetodopago(MetodoPago metodopago) {
		this.metodopago = metodopago;
	}


	public SocioTemporadaDto(Long id, SocioDto socio, TemporadaDto temporada, Boolean iscuotapagada, Integer numsfc,
			Integer numtsf, MetodoPago metodopago) {
		super();
		this.id = id;
		this.socio = socio;
		this.temporada = temporada;
		this.iscuotapagada = iscuotapagada;
		this.numsfc = numsfc;
		this.numtsf = numtsf;
		this.metodopago = metodopago;
	}
}
