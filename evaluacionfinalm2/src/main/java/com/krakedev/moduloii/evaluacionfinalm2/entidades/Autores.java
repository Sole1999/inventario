package com.krakedev.moduloii.evaluacionfinalm2.entidades;

import java.util.Date;

public class Autores {

	private int ID_autor;
	private String nombre;
	private Date fecha_nacimiento;
	private String nacionalidad;
	
	 public Autores() {
			
		}
	
	
	public Autores(int iD_autor, String nombre, Date fecha_nacimiento, String nacionalidad) {
		super();
		ID_autor = iD_autor;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
	}
	public int getID_autor() {
		return ID_autor;
	}
	public void setID_autor(int iD_autor) {
		ID_autor = iD_autor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	@Override
	public String toString() {
		return "Autores [ID_autor=" + ID_autor + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
	
}
