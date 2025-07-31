package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.PedidosBDD;
import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("pedidos")
public class ServiciosPedidos {

	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Pedido pedido) {
		
		PedidosBDD pdBDD = new PedidosBDD();
		
		try {
			pdBDD.insertarPedido(pedido);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("recibir")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registarRecibido(Pedido pedido) {
		PedidosBDD pedBDD = new PedidosBDD();
		
		try {
			pedBDD.registrarPedidoRecibido(pedido);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	@Path("mostrarPorId/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarPorProveedor(@PathParam("id") String identificador) {
		
		ArrayList<DetallePedido> detallePedido = new ArrayList<DetallePedido>();
		
		PedidosBDD pedidoBDD = new PedidosBDD();
		try {
			detallePedido = pedidoBDD.traerPedidosPorProveedor(identificador);
			return Response.ok(detallePedido).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
