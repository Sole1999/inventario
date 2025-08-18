package com.krakedev.hospital.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.hospital.bdd.MedicosBDD;
import com.krakedev.hospital.entidades.Medicos;
import com.krakedev.hospital.excepciones.KrakeDevException;

@Path("medicos")
public class ServiciosMedicos {
	
	@Path("traerporid/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarPorID(@PathParam("id") int id) {
		
		ArrayList<Medicos> medico = new ArrayList<Medicos>();
		MedicosBDD mediBDD = new MedicosBDD();
		
		try {
			medico = mediBDD.traerMedicosPorID(id);
			return Response.ok(medico).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		
	}
	
	
	@Path("agregar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertarDocumento(Medicos medico) {
		MedicosBDD mediBDD = new MedicosBDD();

		try {
			mediBDD.insertarMedico(medico);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}
	

}
