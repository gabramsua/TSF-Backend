package com.example.tsf.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
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
@Table(name="Viaje")
public class ViajeDto {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "equipoid", updatable = true, nullable = true)
    private EquipoDto equipo;
    @OneToOne
    @JoinColumn(name = "competicionid", updatable = true, nullable = true)
    private CompeticionDto competicion;
    @OneToOne
    @JoinColumn(name = "cartelid", updatable = true, nullable = true)
    private FotoDto foto;
    

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private Set<SocioViajeDto> socioviaje = new HashSet<>();

    @OneToMany(mappedBy = "publico", cascade = CascadeType.ALL)
    private Set<PublicoViajeDto> publicoviaje = new HashSet<>();

    // SpringBoot se da cuenta de que hay dos registros iguales y ya no puede ser un OneToOne
//    @OneToOne(mappedBy = "viaje", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "viaje")
    private List<BusDto> bus;
    
    @OneToOne(mappedBy = "viaje")
    private ActividadDto actividad;

//    @OneToMany(mappedBy = "viaje", cascade = CascadeType.ALL)
//    private Set<SocioBanderaDto> sociobandera = new HashSet<>();
    
    private Timestamp fecha;
    private Boolean isfinalizado;
    private Integer precioentrada, resultadolocal, resultadovisitante;
    private String comentarios, horasalida, horallegada, lugarsalida;
	
    public ViajeDto() {
		super();
	}

	public ViajeDto(Long id, EquipoDto equipo, CompeticionDto competicion, FotoDto foto, Timestamp fecha,
			Boolean isfinalizado, Integer precioentrada, Integer resultadolocal, Integer resultadovisitante,
			String comentarios, String horasalida, String horallegada, String lugarsalida) {
		super();
		this.id = id;
		this.equipo = equipo;
		this.competicion = competicion;
		this.foto = foto;
		this.fecha = fecha;
		this.isfinalizado = isfinalizado;
		this.precioentrada = precioentrada;
		this.resultadolocal = resultadolocal;
		this.resultadovisitante = resultadovisitante;
		this.comentarios = comentarios;
		this.horasalida = horasalida;
		this.horallegada = horallegada;
		this.lugarsalida = lugarsalida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EquipoDto getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoDto equipo) {
		this.equipo = equipo;
	}

	public CompeticionDto getCompeticion() {
		return competicion;
	}

	public void setCompeticion(CompeticionDto competicion) {
		this.competicion = competicion;
	}

	public FotoDto getFoto() {
		return foto;
	}

	public void setFoto(FotoDto foto) {
		this.foto = foto;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Boolean getIsFinalizado() {
		return isfinalizado;
	}

	public void setIsFinalizado(Boolean isfinalizado) {
		this.isfinalizado = isfinalizado;
	}

	public Integer getPrecioentrada() {
		return precioentrada;
	}

	public void setPrecioentrada(Integer precioentrada) {
		this.precioentrada = precioentrada;
	}

	public Integer getResultadolocal() {
		return resultadolocal;
	}

	public void setResultadolocal(Integer resultadolocal) {
		this.resultadolocal = resultadolocal;
	}

	public Integer getResultadovisitante() {
		return resultadovisitante;
	}

	public void setResultadovisitante(Integer resultadovisitante) {
		this.resultadovisitante = resultadovisitante;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}

	public String getHorallegada() {
		return horallegada;
	}

	public void setHorallegada(String horallegada) {
		this.horallegada = horallegada;
	}

	public String getLugarsalida() {
		return lugarsalida;
	}

	public void setLugarsalida(String lugarsalida) {
		this.lugarsalida = lugarsalida;
	}

	@Override
	public String toString() {
		return "ViajeDto [id=" + id + ", equipo=" + equipo + ", competicion=" + competicion + ", foto=" + foto
				+ ", fecha=" + fecha + ", isfinalizado=" + isfinalizado + ", precioentrada=" + precioentrada
				+ ", resultadolocal=" + resultadolocal + ", resultadovisitante=" + resultadovisitante + ", comentarios="
				+ comentarios + ", horasalida=" + horasalida + ", horallegada=" + horallegada + ", lugarsalida="
				+ lugarsalida + "]";
	}

    
    
}
