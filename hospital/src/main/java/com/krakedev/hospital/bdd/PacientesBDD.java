package com.krakedev.hospital.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.hospital.entidades.Pacientes;
import com.krakedev.hospital.excepciones.KrakeDevException;
import com.krakedev.hospital.utils.ConexionBDD;

public class PacientesBDD {

	public void agregarPaciente(Pacientes paciente) throws KrakeDevException {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
			
		try{
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into pacientes(nombre,apellido,telefono) "
					+ "values(?,?,?)");
					
			
			ps.setString(1, paciente.getNombre());
			ps.setString(2, paciente.getApellido());
			ps.setString(3, paciente.getTelefono());
			ps.executeUpdate();
				

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar paciente. Detalle:"+e.getMessage());
			
		}		
		
	}
}
