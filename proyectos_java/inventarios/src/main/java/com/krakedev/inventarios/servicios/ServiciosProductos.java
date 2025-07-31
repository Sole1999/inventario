package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProductosBDD;
import com.krakedev.inventarios.entidades.Productos;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("productos")
public class ServiciosProductos {

	@Path("buscar/{subcadena}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("subcadena") String subcadena){
		
		ProductosBDD prodBDD = new ProductosBDD();
		ArrayList<Productos> productos = null;
		
		try {
			productos = prodBDD.buscar(subcadena);
			return Response.ok(productos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Productos producto) {
		
		ProductosBDD prodBDD = new ProductosBDD();
		
		try {
			prodBDD.insertarProducto(producto);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Productos producto) {
		
		ProductosBDD prodBDD = new ProductosBDD();
		
		try {
			prodBDD.actualizar(producto);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("buscarPorId/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") int id) {
		ProductosBDD prodBDD = new ProductosBDD();
		ArrayList<Productos> productos = null;
		try {
			productos = prodBDD.buscarPorId(id);
			return Response.ok(productos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
