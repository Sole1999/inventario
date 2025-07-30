package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DetalleVentas {

	private int codigo;
	private Venta cabeceraVentas; 
	private Productos producto;
	private int cantidad;
	private BigDecimal precioVentas;
	private BigDecimal subtotal;
	private BigDecimal subtotalConIva;
	
	private ArrayList<HistorialStock> historial;
	
	public DetalleVentas() {
		
	}
	
	public DetalleVentas(int codigo, Venta cabeceraVentas, Productos producto, int cantidad,
			BigDecimal precioVentas, BigDecimal subtotal, BigDecimal subtotalConIva) {
		super();
		this.codigo = codigo;
		this.cabeceraVentas = cabeceraVentas;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioVentas = precioVentas;
		this.subtotal = subtotal;
		this.subtotalConIva = subtotalConIva;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Venta getCabeceraVentas() {
		return cabeceraVentas;
	}
	public void setCabeceraVentas(Venta cabeceraVentas) {
		this.cabeceraVentas = cabeceraVentas;
	}
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioVentas() {
		return precioVentas;
	}
	public void setPrecioVentas(BigDecimal precioVentas) {
		this.precioVentas = precioVentas;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getSubtotalConIva() {
		return subtotalConIva;
	}
	public void setSubtotalConIva(BigDecimal subtotalConIva) {
		this.subtotalConIva = subtotalConIva;
	}
	

	public ArrayList<HistorialStock> getHistorial() {
		return historial;
	}

	public void setHistorial(ArrayList<HistorialStock> historial) {
		this.historial = historial;
	}

	@Override
	public String toString() {
		return "DetalleVentas [codigo=" + codigo + ", cabeceraVentas=" + cabeceraVentas + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", precioVentas=" + precioVentas + ", subtotal=" + subtotal
				+ ", subtotalConIva=" + subtotalConIva + "]";
	}
	
	
	
}
