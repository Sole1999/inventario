package com.krakedev.inventarios.entidades;

public class CategoriasUDM {

	private int codigo;
	private String nombre;
	
	public CategoriasUDM() {
		
	}
	
	public CategoriasUDM(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "CategoriasUDM [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
