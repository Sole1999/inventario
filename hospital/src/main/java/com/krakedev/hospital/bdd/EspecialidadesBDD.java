package com.krakedev.hospital.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.hospital.entidades.Especialidades;
import com.krakedev.hospital.excepciones.KrakeDevException;
import com.krakedev.hospital.utils.ConexionBDD;

public class EspecialidadesBDD {

public ArrayList<Especialidades> recuperarTodo() throws KrakeDevException{
		
		ArrayList<Especialidades> especialidades = new ArrayList<Especialidades>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Especialidades especialidad = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from especialidades");
			///ps.setString(1, "%"+subcadena.toUpperCase()+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				especialidad = new Especialidades(id, nombre, descripcion);
				especialidades.add(especialidad);

			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar especialidades. Detalle: "+e.getMessage());
		}
		
		return especialidades;
	}
}
