package com.krakedev.inventarios.entidades;

public class UnidadesMedida {

	private String nombre;
	private String descripcion;
	private CategoriasUDM categoriaUDM;
	
	public UnidadesMedida() {
		
	}
	
	public UnidadesMedida(String nombre, String descripcion, CategoriasUDM categoriaUDM) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoriaUDM = categoriaUDM;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public CategoriasUDM getCategoriaUDM() {
		return categoriaUDM;
	}
	public void setCategoriaUDM(CategoriasUDM categoriaUDM) {
		this.categoriaUDM = categoriaUDM;
	}

	@Override
	public String toString() {
		return "UnidadesMedida [nombre=" + nombre + ", descripcion=" + descripcion + ", categoriaUDM=" + categoriaUDM
				+ "]";
	}
	
}
