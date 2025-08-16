package com.krakedev.hospital.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.hospital.bdd.EspecialidadesBDD;
import com.krakedev.hospital.entidades.Especialidades;
import com.krakedev.hospital.excepciones.KrakeDevException;

@Path("especialidades")
public class ServiciosEspecialidades {
	
	@Path("mostrar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarTodo() {
		
		EspecialidadesBDD especialBDD = new EspecialidadesBDD();
		ArrayList<Especialidades> especialidades = null;
		try {
			especialidades = especialBDD.recuperarTodo();
			return Response.ok(especialidades).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		
	}

}
