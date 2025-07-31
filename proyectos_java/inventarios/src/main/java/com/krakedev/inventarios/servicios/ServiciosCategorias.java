package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.CategoriasBDD;
import com.krakedev.inventarios.entidades.Categorias;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("categorias")
public class ServiciosCategorias {

	@Path("agregar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Categorias categoria) {
		
		CategoriasBDD categoriaBDD = new CategoriasBDD();
		
		try {
			categoriaBDD.insertarCategoria(categoria);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Categorias categoria) {
		
		CategoriasBDD categoriaBDD = new CategoriasBDD();
		
		try {
			categoriaBDD.actualizarCategoria(categoria);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("mostrar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response enlistar() {
		
		ArrayList<Categorias> categorias = new ArrayList<Categorias>();
		CategoriasBDD categoriaBDD = new CategoriasBDD();
		
		try {
			categorias = categoriaBDD.recuperarCategorias();
			return Response.ok(categorias).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
