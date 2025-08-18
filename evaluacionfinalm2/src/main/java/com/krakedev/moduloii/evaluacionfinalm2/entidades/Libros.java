package com.krakedev.moduloii.evaluacionfinalm2.entidades;

import java.util.Date;

public class Libros {
 //private int ID_libro;
 private String titulo;
 private int autor_id;
 private int genero_id;
 private Date anio_publicacion;
 private boolean  estado_disponible;
 
 public Libros() {
		
	}
/* 
public int getID_libro() {
	return ID_libro;
}
public void setID_libro(int iD_libro) {
	ID_libro = iD_libro;
}*/
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public int getAutor_id() {
	return autor_id;
}
public void setAutor_id(int autor_id) {
	this.autor_id = autor_id;
}
public int getGenero_id() {
	return genero_id;
}
public void setGenero_id(int genero_id) {
	this.genero_id = genero_id;
}
public Date getAnio_publicacion() {
	return anio_publicacion;
}
public void setAnio_publicacion(Date anio_publicacion) {
	this.anio_publicacion = anio_publicacion;
}
public boolean isEstado_disponible() {
	return estado_disponible;
}
public void setEstado_disponible(boolean estado_disponible) {
	this.estado_disponible = estado_disponible;
}
public Libros( String titulo, int autor_id, int genero_id, Date anio_publicacion,
		boolean estado_disponible) {
	super();
	//ID_libro = iD_libro;
	this.titulo = titulo;
	this.autor_id = autor_id;
	this.genero_id = genero_id;
	this.anio_publicacion = anio_publicacion;
	this.estado_disponible = estado_disponible;
}
@Override
public String toString() {
	return "Libros [ID_libro="  + ", titulo=" + titulo + ", autor_id=" + autor_id + ", genero_id=" + genero_id
			+ ", anio_publicacion=" + anio_publicacion + ", estado_disponible=" + estado_disponible + "]";
}
 
 
}
