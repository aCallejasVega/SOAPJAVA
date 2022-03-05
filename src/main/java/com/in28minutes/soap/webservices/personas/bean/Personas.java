package com.in28minutes.soap.webservices.personas.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Personas {
	private Integer idPersona;
	private String nombres;
	private String paterno;
	private String materno;
	private Date fechaNacimiento;
	private String direccion;
	private String telefono;
	private String sexo;
	private String estadoCivil;
	private BigDecimal salario;
	private Boolean activo;

	public Personas() {

	}

	public Personas(Integer idPersona, String nombres, String paterno, String materno, Date fechaNacimiento,
			String direccion, String telefono, String sexo, String estadoCivil, BigDecimal salario, Boolean activo) {

		this.idPersona = idPersona;
		this.nombres = nombres;
		this.paterno = paterno;
		this.materno = materno;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.salario = salario;
		this.activo = activo;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
