package com.krakedev.hospital.entidades;

import java.util.Date;

public class Citas {
	private int id;
	private Pacientes pacienteId;
	private Medicos medicoId;
	private Date fecha;
	private String servicio;
	
	public Citas() {
		super();
	}
	
	public Citas(int id, Pacientes pacienteId, Medicos medicoId, Date fecha, String servicio) {
		super();
		this.id = id;
		this.pacienteId = pacienteId;
		this.medicoId = medicoId;
		this.fecha = fecha;
		this.servicio = servicio;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pacientes getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Pacientes pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Medicos getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Medicos medicoId) {
		this.medicoId = medicoId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	
	@Override
	public String toString() {
		return "Citas [id=" + id + ", pacienteId=" + pacienteId + ", medicoId=" + medicoId + ", fecha=" + fecha
				+ ", servicio=" + servicio + "]";
	}
	
	
}
