package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.TiposDocumento;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class TipoDocumentoBDD {

	public ArrayList<TiposDocumento> recuperarTodo() throws KrakeDevException{
		
		ArrayList<TiposDocumento> tipos = new ArrayList<TiposDocumento>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TiposDocumento tipo = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from tipo_documentos");
			///ps.setString(1, "%"+subcadena.toUpperCase()+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String codigo = rs.getString("codigo");
				String descripcion = rs.getString("descripcion");
				tipo = new TiposDocumento(codigo, descripcion);
				tipos.add(tipo);

			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: "+e.getMessage());
		}
		
		return tipos;
	}
}
