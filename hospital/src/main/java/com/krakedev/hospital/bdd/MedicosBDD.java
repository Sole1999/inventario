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
	
public ArrayList<Medicos> traerMedicosPorID(int identificador) throws KrakeDevException{
		
		ArrayList<Medicos> medicos = new ArrayList<Medicos>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select md.*, esp.nombre from medicos md, especialidades esp "
					+ " where md.especialidades_id = esp.id"
					+ "	and md.id = ? ");
			ps.setInt(1, identificador);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
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


public void insertarMedico(Medicos medico) throws KrakeDevException{
	
	Connection con = null;
	PreparedStatement ps = null;
	
	try {
		con = ConexionBDD.obtenerConexion();
		ps = con.prepareStatement("INSERT INTO medicos (especialidades_id, nombre, apellido, telefono, correo) "
				+ "values(?, ?, ?, ?, ?)");
		ps.setInt(1, medico.getEspecialidad().getId());
		ps.setString(2, medico.getNombre());
		ps.setString(3, medico.getApellido());
		ps.setString(4, medico.getTelefono());
		ps.setString(5, medico.getCorreo());
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
