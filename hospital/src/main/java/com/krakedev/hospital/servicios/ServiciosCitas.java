package com.krakedev.hospital.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.hospital.bdd.CitasBDD;
import com.krakedev.hospital.entidades.Citas;
import com.krakedev.hospital.excepciones.KrakeDevException;

@Path("citas")
public class ServiciosCitas {
	
	@Path("agregarCitas")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response agregarPaciente(Citas cita) {
		
		CitasBDD citaBDD = new CitasBDD();
		try {
			citaBDD.insertarCita(cita);;
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

}
