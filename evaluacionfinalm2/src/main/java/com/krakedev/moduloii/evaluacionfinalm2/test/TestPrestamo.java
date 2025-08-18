package com.krakedev.moduloii.evaluacionfinalm2.test;

import com.krakedev.moduloii.evaluacionfinalm2.entidades.Prestamos;
import com.krakedev.moduloii.evaluacionfinalm2.utils.ConexionBDD;
import com.krakedev.moduloii.evaluacionfinalm2.utils.Convertidor;

public class TestPrestamo {

	public static void main(String[] args) {
		ConexionBDD conx = new ConexionBDD();

		Prestamos prestamo = null;
		
		String fechaS="2025/04/03";
		String fechaDS="2025/05/03";
		try {
			
			prestamo = new Prestamos(1, Convertidor.convertirAFecha(fechaS), Convertidor.convertirAFecha(fechaDS), "Mateo");
			conx.agregarPrestamo(prestamo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
