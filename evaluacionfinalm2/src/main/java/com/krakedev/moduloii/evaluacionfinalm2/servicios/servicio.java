package com.krakedev.moduloii.evaluacionfinalm2.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.moduloii.evaluacionfinalm2.entidades.Generos;
import com.krakedev.moduloii.evaluacionfinalm2.entidades.Libros;
import com.krakedev.moduloii.evaluacionfinalm2.entidades.Prestamos;
import com.krakedev.moduloii.evaluacionfinalm2.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinalm2.utils.ConexionBDD;

@Path("servicio")
public class servicio {

	@Path("insertarLibro")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Libros libro) {
		System.out.println(libro);
		ConexionBDD conx = new ConexionBDD();

		try {
			conx.insertar(libro);
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Path("agregarGenero")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarGenero(Generos genero) {
		System.out.println(genero);
		ConexionBDD conx = new ConexionBDD();

		try {
			conx.agregarGenero(genero);
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Path("agregarPrestamo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarPrestamo(Prestamos prestamo) {
		System.out.println(prestamo);
		ConexionBDD conx = new ConexionBDD();

		try {
			conx.agregarPrestamo(prestamo);
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Path("buscarPrestamos/{ID_libroParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPrestamos(@PathParam("ID_libroParam") int idLibro) {
		ConexionBDD conx = new ConexionBDD();
		ArrayList<Prestamos> prs = null;
		try {
			prs = conx.consultarPrestamos(idLibro);
			return Response.ok(prs).build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("eliminarGeneros/{id_generoParam}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarGeneros(@PathParam("id_generoParam") int id_genero) {
		ConexionBDD conx = new ConexionBDD();
        try {
        	conx.eliminarGenero(id_genero);
        	return Response.ok().build();
        } catch (InventarioException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
