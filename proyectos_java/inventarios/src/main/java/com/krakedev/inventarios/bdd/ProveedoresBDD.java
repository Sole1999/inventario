package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TiposDocumento;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProveedoresBDD {

	public ArrayList<Proveedor> buscar(String subcadena) throws KrakeDevException{
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Proveedor proveedor = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select identificador, tipo_de_documento_fk, td.descripcion, nombre, telefono, correo, direccion "
					+ "from proveedores prov, tipo_documentos td "
					+ "where prov.tipo_de_documento_fk = td.codigo "
					+ "and upper(nombre) like ?");
			ps.setString(1, "%"+subcadena.toUpperCase()+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String identificador = rs.getString("identificador");
				String codigoTipoDocumento = rs.getString("tipo_de_documento_fk");
				String descripcionTipoDocumento = rs.getString("descripcion");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				TiposDocumento td = new TiposDocumento(codigoTipoDocumento, descripcionTipoDocumento);
				proveedor = new Proveedor(identificador, td, nombre, telefono, correo, direccion);
				proveedores.add(proveedor);

			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: "+e.getMessage());
		}
		
		return proveedores;
				
	}
	
	
	public void insertarProveedor(Proveedor proveedor) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		//Proveedor proveedor = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into proveedores (identificador,tipo_de_documento_fk,nombre,telefono,correo,direccion) "
					+"values(?,?,?,?,?,?)");
			ps.setString(1, proveedor.getIdentificador());
			ps.setString(2, proveedor.getTipoDocumento().getCodigo());
			ps.setString(3, proveedor.getNombre());
			ps.setString(4, proveedor.getTelefono());
			ps.setString(5, proveedor.getCorreo());
			ps.setString(6, proveedor.getDireccion());
			ps.executeUpdate();
;		} catch (KrakeDevException e) {
			
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar proveedor. Detalle: "+e.getMessage());
		}
	}
	
	
	public ArrayList<Proveedor> buscarPorId(String identificador) throws KrakeDevException{
		
		ArrayList<Proveedor> proveedorId = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement ps = null;
		Proveedor proveedor = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			
			ps = con.prepareStatement("select * from proveedores where identificador like ?");
			ps.setString(1, identificador);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("identificador");
				String tipoDocumento = rs.getString("tipo_de_documento_fk");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				
				TiposDocumento tipo = new TiposDocumento(tipoDocumento);
				proveedor = new Proveedor(id, tipo, nombre, telefono, correo, direccion);
				proveedorId.add(proveedor);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al buscar proveedor por id. Detalle: "+e.getMessage());
		}
			
		return proveedorId;
	}
}
