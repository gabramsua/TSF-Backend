package com.example.tsf.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Socio")
public class SocioDto {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numregistro")
    private Integer numRegistro;
    
    private String dni, nombre, apellidos, email, direccion, localidad, provincia;
    
    private Integer telefono;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private Set<SocioTemporadaDto> socioTemporada;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private Set<SocioViajeDto> socioviaje;
    
    public SocioDto() {}

	public SocioDto(Long id, Integer numRegistro, String dni, String nombre, String apellidos, String email,
			String direccion, String localidad, String provincia, Integer telefono) {
		super();
		this.id = id;
		this.numRegistro = numRegistro;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(Integer numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "SocioDto [id=" + id + ", numRegistro=" + numRegistro + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", email=" + email + ", direccion=" + direccion + ", localidad="
				+ localidad + ", provincia=" + provincia + ", telefono=" + telefono + "]";
	}
    
    
}
