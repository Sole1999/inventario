package com.krakedev.hospital.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.hospital.bdd.PacientesBDD;
import com.krakedev.hospital.entidades.Pacientes;
import com.krakedev.hospital.excepciones.KrakeDevException;

@Path("pacientes")
public class ServiciosPaciente {

	@Path("agregarPaciente")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response agregarPaciente(Pacientes paciente) {
		
		PacientesBDD paciBDD = new PacientesBDD();
		try {
			paciBDD.agregarPaciente(paciente);;
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}
}
