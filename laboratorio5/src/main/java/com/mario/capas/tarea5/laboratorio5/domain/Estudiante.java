package com.mario.capas.tarea5.laboratorio5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(generator="estudiante_c_usuario_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "estudiante_c_usuario_seq", sequenceName = "public.estudiante_c_usuario_seq", allocationSize = 1)
	@Column(name = "c_usuario")
	private Integer cusuario;

	@Column(name = "nombre")
	@Size(min = 1,max = 50,message = "Escriba su nombre de 1 a 50 caracteres")
	private String nombre;

	@Column(name = "apellido")
	@Size(min = 1,max = 50,message = "Escriba su apellido de 1 a 50 caracteres")
	private String apellido;

	@Column(name = "carne")
	@Size(min = 1,max = 10,message = "Escriba su carne de 1 a 10 caracteres")
	private String carne;

	@Column(name = "carrera")
	@Size(min = 1,max = 100,message = "Escriba su carrera de 1 a 100 caracteres")
	private String carrera;
	
	public Estudiante() {
		
	}

	public Integer getCusuario() {
		return cusuario;
	}

	public void setCusuario(Integer cusuario) {
		this.cusuario = cusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	
}
