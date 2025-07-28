package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DetallePedido {

	private int codigo;
	private Pedido cabecera;
	private Productos producto;
	private int cantidadSolicitada;
	private BigDecimal subtotal;
	private int cantidadRecibida;
	
	private ArrayList<HistorialStock> historial;
	
	public DetallePedido() {
		
	}
	
	public DetallePedido(int codigo, Pedido cabecera, Productos producto, int cantidadSolicitada, BigDecimal subtotal,
			int cantidadRecibida) {
		super();
		this.codigo = codigo;
		this.cabecera = cabecera;
		this.producto = producto;
		this.cantidadSolicitada = cantidadSolicitada;
		this.subtotal = subtotal;
		this.cantidadRecibida = cantidadRecibida;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Pedido getCabecera() {
		return cabecera;
	}
	public void setCabecera(Pedido cabecera) {
		this.cabecera = cabecera;
	}
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public int getCantidadRecibida() {
		return cantidadRecibida;
	}
	public void setCantidadRecibida(int cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	
	

	public ArrayList<HistorialStock> getHistorial() {
		return historial;
	}

	public void setHistorial(ArrayList<HistorialStock> historial) {
		this.historial = historial;
	}

	@Override
	public String toString() {
		return "DetallePedido [codigo=" + codigo + ", cabecera=" + cabecera + ", producto=" + producto
				+ ", cantidadSolicitada=" + cantidadSolicitada + ", subtotal=" + subtotal + ", cantidadRecibida="
				+ cantidadRecibida + "]";
	}
	
}
