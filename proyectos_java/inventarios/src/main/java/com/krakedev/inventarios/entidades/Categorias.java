package com.krakedev.inventarios.entidades;

public class Categorias {

	private int codigo;
	private String nombre;
	private Categorias CategoriaPadre;

	public Categorias() {
		
	}
	
	public Categorias(int codigo, String nombre, Categorias categoriaPadre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		CategoriaPadre = categoriaPadre;
	}
	
	public Categorias(int codigo, String nombre) {
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
	public Categorias getCategoriaPadre() {
		return CategoriaPadre;
	}
	public void setCategoriaPadre(Categorias categoriaPadre) {
		CategoriaPadre = categoriaPadre;
	}


	@Override
	public String toString() {
		return "Categorias [codigo=" + codigo + ", nombre=" + nombre + ", CategoriaPadre=" + CategoriaPadre + "]";
	}
	
}
