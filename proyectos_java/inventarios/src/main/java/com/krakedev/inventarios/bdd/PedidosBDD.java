package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.HistorialStock;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Productos;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidosBDD {

	public void insertarPedido(Pedido pedido) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;
		
		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_pedido(proveedor,fecha,estado_fk) "
					+ "values(?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificador());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "S");
			
			ps.executeUpdate();
			
			rsClave = ps.getGeneratedKeys();
			
			if(rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}
			
			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido det;
			for(int i=0; i<detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				psDet = con.prepareStatement("insert into detalle_pedido(cabecera_pedido,producto,cantidad_solicitada,cantidad_recibida,subtotal) "
						+ "values(?,?,?,?,?);");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidadSolicitada());
				psDet.setInt(4, 0);
				//double subtotal = det.getProducto().getPrecioVenta()*det.getCantidadSolicitada();
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(5, subtotal);
				
				psDet.executeUpdate();				
			}
			
			System.out.println("CODIGO GENERADO>>> "+codigoCabecera);
			
		} catch (KrakeDevException e) {
			
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new KrakeDevException("Erro al insertar pedido. Detalle: "+ e.getMessage());
		}
	}
	
	public void registrarPedidoRecibido(Pedido pedido) throws KrakeDevException{
		
		Connection con= null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		
		Date fechaActual = new Date();
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());
		
		ResultSet clave = null;
		int codigoDetalle = 0;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update cabecera_pedido set estado_fk = ? where numero = ? ");
			
			ps.setString(1, "R");
			ps.setInt(2, pedido.getCodigo());
			
			ps.executeUpdate();
			
			ArrayList<DetallePedido> detalle = pedido.getDetalles();
			DetallePedido det;
			for(int i=0; i<detalle.size(); i++) {
				det = detalle.get(i);
				ps2 = con.prepareStatement("update detalle_pedido set cantidad_recibida = ? , subtotal = ? where codigo = ? ", 
						Statement.RETURN_GENERATED_KEYS);
				
				//clave = ps.getGeneratedKeys();
				
				/*if(clave.next()) {
					codigoDetalle = clave.getInt(1);
				}*/
				
				ps2.setInt(1, det.getCantidadRecibida());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadRecibida());
				BigDecimal subtotal = pv.multiply(cantidad);
				ps2.setBigDecimal(2, subtotal);
				ps2.setInt(3, det.getCodigo());
				
				ps2.executeUpdate();
				
				ArrayList<HistorialStock> historial = det.getHistorial();
				
				ps3 = con.prepareStatement("insert into historial_stocks(fecha,referencia,producto_fk,cantidad) "
						+ "values(?, ?, ?, ?);");
				ps3.setTimestamp(1, fechaHoraActual);
				ps3.setString(2, "PEDIDO "+ det.getCodigo());
				ps3.setInt(3, det.getProducto().getCodigo());
				ps3.setInt(4, det.getCantidadRecibida());
				
				ps3.executeUpdate();
			} 
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al registrar pedido recibido. Detalle: "+ e.getMessage());
		}
	}
	
	
	public ArrayList<DetallePedido> traerPedidosPorProveedor(String identificador) throws KrakeDevException{
		
		ArrayList<DetallePedido> pedidos = new ArrayList<DetallePedido>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select dt.* from detalle_pedido dt, proveedores prov, cabecera_pedido cb "
					+ "where dt.cabecera_pedido = cb.numero "
					+ "and cb.proveedor like ? "
					+ "and cb.proveedor = prov.identificador ");
			ps.setString(1, identificador);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int codigoPedido = rs.getInt("codigo");
				int cabeceraPedido = rs.getInt("cabecera_pedido");
				int producto = rs.getInt("producto");
				int cantidadSolicitada = rs.getInt("cantidad_solicitada");
				int cantidadRecibida = rs.getInt("cantidad_recibida");
				BigDecimal subtotal = rs.getBigDecimal("subtotal");
				
				Productos productoClase = new Productos();
				productoClase.setCodigo(producto);
				
				Pedido pedidoClase = new Pedido();
				pedidoClase.setCodigo(cabeceraPedido);
				/*
				Productos codigoProducto;
				codigoProducto.setCodigo(producto);
				
				Pedido codidoCabecera;
				codidoCabecera.setCodigo(cabeceraPedido);
				*/
				DetallePedido pedido = new DetallePedido(codigoPedido, pedidoClase, productoClase, cantidadSolicitada, cantidadRecibida, subtotal);
				pedidos.add(pedido);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al traer pedido por proveedor. Detalles: "+e.getMessage());
		}
		
		
		return pedidos;
	}
	
}
