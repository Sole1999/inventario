package com.krakedev.inventarios.entidades;

public class Proveedor {

	private String indentificador;
	private TiposDocumento tipoDocumento;
	private String nombre;
	private String telefono;
	private String correo;
	private String direccion;
	
	
	public Proveedor() {
		
	}
	
	public Proveedor(String indentificador, TiposDocumento tipoDocumento, String nombre, String telefono, String correo,
			String direccion) {
		super();
		this.indentificador = indentificador;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}
	
	
	public String getIndentificador() {
		return indentificador;
	}
	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}
	public TiposDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TiposDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Proveedor [indentificador=" + indentificador + ", tipoDocumento=" + tipoDocumento + ", nombre=" + nombre
				+ ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + "]";
	}
	
}
