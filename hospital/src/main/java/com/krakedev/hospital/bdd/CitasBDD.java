package com.krakedev.hospital.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.krakedev.hospital.entidades.Citas;
import com.krakedev.hospital.excepciones.KrakeDevException;
import com.krakedev.hospital.utils.ConexionBDD;

public class CitasBDD {

	public void insertarCita(Citas  cita) throws KrakeDevException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("INSERT INTO citas (paciente_id, medico_id, fecha, servicio) "
					+ "values(?, ?, ?, ?)");
			ps.setInt(1, cita.getPacienteId().getId());
			ps.setInt(2, cita.getMedicoId().getId());
			ps.setDate(3, fechaSQL);
			ps.setString(4, cita.getServicio());
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar medico. Detalle: "+e.getMessage());
		}
	}
}
