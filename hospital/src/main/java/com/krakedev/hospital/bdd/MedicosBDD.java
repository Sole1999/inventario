package com.krakedev.hospital.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.hospital.entidades.Especialidades;
import com.krakedev.hospital.entidades.Medicos;
import com.krakedev.hospital.excepciones.KrakeDevException;
import com.krakedev.hospital.utils.ConexionBDD;

public class MedicosBDD {
	
public ArrayList<Medicos> traerMedicosPorID(String identificador) throws KrakeDevException{
		
		ArrayList<Medicos> medicos = new ArrayList<Medicos>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select md.*, esp.nombre from medicos md, especialidades esp "
					+ " where md.especialidades_id = esp.id"
					+ "	and md.id like ? ");
			ps.setString(1, identificador);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				int especialidad = rs.getInt("especialidades_id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				
				Especialidades especialidadClase = new Especialidades();
				especialidadClase.setId(especialidad);
				
				Medicos medico = new Medicos(id, especialidadClase, nombre, apellido, telefono, correo);
				medicos.add(medico);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al traer medicos por ID. Detalles: "+e.getMessage());
		}
		
		
		return medicos;
	}

}
