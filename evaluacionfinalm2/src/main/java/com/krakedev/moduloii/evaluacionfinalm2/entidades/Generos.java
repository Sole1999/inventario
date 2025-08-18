package com.krakedev.moduloii.evaluacionfinalm2.entidades;

public class Generos {
	//private int ID_genero;
	private String nombre;
	
	 public Generos() {
			
		}
	
	/*public int getID_genero() {
		return ID_genero;
	}
	public void setID_genero(int iD_genero) {
		ID_genero = iD_genero;
	}*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Generos( String nombre) {
		super();
		//ID_genero = iD_genero;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Generos [ID_genero="  + ", nombre=" + nombre + "]";
	}
	
	
	
}
