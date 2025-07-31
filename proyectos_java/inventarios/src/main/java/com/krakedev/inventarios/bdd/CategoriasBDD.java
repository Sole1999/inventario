package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categorias;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CategoriasBDD {

	public void insertarCategoria(Categorias categoria) throws KrakeDevException {

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into categorias(nombre, categoria_padre) "
					+ "values(? , ?);");
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
			
			ps.executeUpdate();
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al actualizar categoria.  Detalle: "+ e.getMessage());
		}
	}
	
	public void actualizarCategoria(Categorias categoria) throws KrakeDevException {

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("UPDATE categorias SET nombre = ?, categoria_padre = ? WHERE codigo_cat = ? ");
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
			ps.setInt(3, categoria.getCodigo());
			
			ps.executeUpdate();
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al actualizar categoria.  Detalle: "+ e.getMessage());
		}
	}
	
	public ArrayList<Categorias> recuperarCategorias() throws KrakeDevException {

		ArrayList<Categorias> categorias = new ArrayList<Categorias>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Categorias categoria = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("SELECT * from categorias ");
			//ps.setString(1, categoria.getNombre());
			//ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo_cat");
				String nombre = rs.getString("nombre");
				int codigoPadre = rs.getInt("categoria_padre");
				Categorias categoriaPadre = new Categorias();
				categoriaPadre.setCodigo(codigoPadre);
				categoria = new Categorias(codigo, nombre, categoriaPadre);
				categorias.add(categoria);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al actualizar categoria.  Detalle: "+ e.getMessage());
		}
		
		return categorias;
	}
	

}
