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

import com.krakedev.inventarios.entidades.DetalleVentas;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class VentasBDD {

	public void insertarVenta(Venta venta) throws KrakeDevException {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement psCabecera = null;
		PreparedStatement psHistorial = null;

		Date fechaActual = new Date();
		java.sql.Date fechaSql = new java.sql.Date(fechaActual.getTime());
		
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());

		ResultSet rsCodigo = null;
		int codigoCab = 0;
		int codigoVenta = 0;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"insert into cabecera_ventas(fecha,total_sin_iva,iva,total) " + "values(?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, fechaSql);
			ps.setBigDecimal(2, venta.getTotalSinIva());
			ps.setBigDecimal(3, venta.getIva());
			ps.setBigDecimal(4, venta.getTotal());

			ps.executeUpdate();

			rsCodigo = ps.getGeneratedKeys();

			if (rsCodigo.next()) {
				codigoCab = rsCodigo.getInt(1);
			}

			ArrayList<DetalleVentas> detalleVentas = venta.getDetalles();
			DetalleVentas det;

			BigDecimal totalSinIva = BigDecimal.ZERO;
			BigDecimal ivaTotal = BigDecimal.ZERO;
			BigDecimal totales = BigDecimal.ZERO;
			BigDecimal porcentajeIVA = new BigDecimal("0.12");
			//BigDecimal cantidadVenta = BigDecimal.ZERO;
			//BigDecimal totalCantidad = BigDecimal.ZERO;

			for (int i = 0; i < detalleVentas.size(); i++) {
				det = detalleVentas.get(i);

				ps2 = con.prepareStatement(
						"insert into detalle_ventas(cabecera_ventas,producto_fk,cantidad,precio_ventas,subtotal,subtotal_con_iva) "
								+ "values(?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

				ps2.setInt(1, codigoCab);
				ps2.setInt(2, det.getProducto().getCodigo());
				ps2.setInt(3, det.getCantidad());
				ps2.setBigDecimal(4, det.getProducto().getPrecioVenta());

				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidad());
				BigDecimal subtotal = pv.multiply(cantidad);

				ps2.setBigDecimal(5, subtotal);

				BigDecimal iva = new BigDecimal("1.12");
				BigDecimal total = subtotal;
				
				if (det.getProducto().isTieneIva()) {
					total = subtotal.multiply(iva);
					System.out.println("SI TIENE IVA>>> " + total);
				}

				ps2.setBigDecimal(6, total);
				ps2.executeUpdate();
				
				rsCodigo = ps2.getGeneratedKeys();

				if (rsCodigo.next()) {
					codigoVenta = rsCodigo.getInt(1);
				}

				System.out.println("CODIGO GENERADO>>> " + codigoCab);
				System.out.println("TOTAL>>> " + total);

				
				if (det.getProducto().isTieneIva()) {
					BigDecimal ivaProducto = subtotal.multiply(porcentajeIVA);
					ivaTotal = ivaTotal.add(ivaProducto);
					totalSinIva = totalSinIva.add(subtotal); 
				} else {
					totalSinIva = totalSinIva.add(subtotal); 
				}
				
				
				int cantidadVenta = det.getCantidad()* -1;
				
				psHistorial = con.prepareStatement("insert into historial_stocks(fecha,referencia,producto_fk,cantidad) "
						+ "values(?, ?, ?, ?);");
				
				psHistorial.setTimestamp(1, fechaHoraActual);
				psHistorial.setString(2, "VENTA "+ codigoVenta);
				psHistorial.setInt(3, det.getProducto().getCodigo());
				psHistorial.setInt(4, cantidadVenta);
				
				psHistorial.executeUpdate();
			}

			totales = totalSinIva.add(ivaTotal);

			psCabecera = con.prepareStatement("UPDATE cabecera_ventas SET total_sin_iva = ?, iva = ?, total = ? WHERE codigo = ?");

			psCabecera.setBigDecimal(1, totalSinIva);
			psCabecera.setBigDecimal(2, ivaTotal);
			psCabecera.setBigDecimal(3, totales);
			psCabecera.setInt(4, codigoCab);
			
			psCabecera.executeUpdate();
			
			
			System.out.println("CODIGO GENERADO VENTA>>> " + codigoVenta);

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar venta. Detalle: " + e.getMessage());
		}
	}

}
