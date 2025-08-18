package com.krakedev.moduloii.evaluacionfinalm2.entidades;

import java.util.Date;

public class Prestamos {

	//private int ID_prestamo;
	private int libro_id;
	private Date fecha_prestamo;
	private Date fecha_devolucion;
	private String usuario;
	
	public Prestamos() {
		
	}
	
	public Prestamos( int libro_id, Date fecha_prestamo, Date fecha_devolucion, String usuario) {
		super();
		//ID_prestamo = iD_prestamo;
		this.libro_id = libro_id;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
		this.usuario = usuario;
	}

	/*public int getID_prestamo() {
		return ID_prestamo;
	}

	public void setID_prestamo(int iD_prestamo) {
		ID_prestamo = iD_prestamo;
	}*/

	public int getLibro_id() {
		return libro_id;
	}

	public void setLibro_id(int libro_id) {
		this.libro_id = libro_id;
	}

	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Prestamos [ID_prestamo="  + ", libro_id=" + libro_id + ", fecha_prestamo=" + fecha_prestamo
				+ ", fecha_devolucion=" + fecha_devolucion + ", usuario=" + usuario + "]";
	}
	
	
	
}
