package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categorias;
import com.krakedev.inventarios.entidades.Productos;
import com.krakedev.inventarios.entidades.UnidadesMedida;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductosBDD {

	public ArrayList<Productos> buscar(String subcadena) throws KrakeDevException{
		ArrayList<Productos> productos = new ArrayList<Productos>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Productos producto = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select prod.codigo_producto, prod.nombre as nombre_producto, "
					+ "udm.nombre as nombre_udm, udm.descripcion as descripcion_udm, "
					+ "cast(prod.precio_de_venta as decimal(6,2)), prod.tiene_iva, "
					+ "cast(prod.coste as decimal(5,4)), "
					+ "prod.categoria, cat.nombre as nombre_categoria, stock "
					+ "from productos prod, unidades_medida udm, categorias cat "
					+ "where prod.udm = udm.nombre "
					+ "and prod.categoria = cat.codigo_cat "
					+ "and upper(prod.nombre) like ?");
			ps.setString(1, "%"+subcadena.toUpperCase()+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int codigoProducto = rs.getInt("codigo_producto");
				String nombreProducto = rs.getString("nombre_producto");
				String nombreUnidadMedida = rs.getString("nombre_udm");
				String descripcionUnidadMedida = rs.getString("descripcion_udm");
				BigDecimal precioVenta = rs.getBigDecimal("precio_de_venta");
				boolean tieneIva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int codigoCategoria = rs.getInt("categoria");
				String nombreCategoria = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");
				
				
				UnidadesMedida udm = new UnidadesMedida();
				udm.setNombre(nombreUnidadMedida);
				udm.setDescripcion(descripcionUnidadMedida);
				
				//producto = new Productos(identificador, td, nombre, telefono, correo, direccion);
				
				Categorias categoriaRs = new Categorias(codigoCategoria, nombreCategoria);
				
				
				producto = new Productos();
				producto.setCodigo(codigoProducto);
				producto.setNombre(nombreProducto);
				producto.setUdm(udm);
				producto.setPrecioVenta(precioVenta);
				producto.setTieneIva(tieneIva);
				producto.setCoste(coste);
				producto.setCategoria(categoriaRs);
				producto.setStock(stock);
				productos.add(producto);

			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: "+e.getMessage());
		}
		
		return productos;
				
	}
	
	
	public void insertarProducto(Productos producto) throws KrakeDevException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into productos(nombre, udm, precio_de_venta, tiene_iva, coste, categoria, stock) "
					+"values(?, ?, ?, ?, ?, ?, ?);");
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUdm().getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBoolean(4, producto.isTieneIva());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigo());
			ps.setInt(7, producto.getStock());
			
			ps.executeUpdate();
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar producto.  Detalle: "+ e.getMessage());
		}
	}
	
	public void actualizar(Productos producto) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("Update productos SET nombre = ?, udm = ?, precio_de_venta = ?, tiene_iva = ?, coste = ?, categoria = ?, stock = ? WHERE codigo_producto = ? ");
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUdm().getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBoolean(4, producto.isTieneIva());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigo());
			ps.setInt(7, producto.getStock());
			ps.setInt(8, producto.getCodigo());
			
			ps.executeUpdate();
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al actualizar producto.  Detalle: "+ e.getMessage());
		}
	}
	
	public ArrayList<Productos> buscarPorId(int id) throws KrakeDevException{
		ArrayList<Productos> productos = new ArrayList<Productos>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from productos where codigo_producto = ? ");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo_producto");
				String nombre = rs.getString("nombre");
				String udm = rs.getString("udm");
				BigDecimal precioVenta = rs.getBigDecimal("precio_de_venta");
				boolean tieneIva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int categoria = rs.getInt("categoria");
				int stock = rs.getInt("stock");
				
				Categorias categoriaClase = new Categorias();
				categoriaClase.setCodigo(categoria);
				
				UnidadesMedida udmClase = new UnidadesMedida();
				udmClase.setDescripcion(udm);
				
				Productos productoId = new Productos();
				productoId.setCodigo(codigo);
				productoId.setNombre(nombre);
				productoId.setUdm(udmClase);
				productoId.setPrecioVenta(precioVenta);
				productoId.setTieneIva(tieneIva);
				productoId.setCoste(coste);
				productoId.setCategoria(categoriaClase);
				productoId.setStock(stock);
				productos.add(productoId);
				
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al buscar producto por id. Detalle "+e.getMessage());
		}
		return productos;
	}
	
}
