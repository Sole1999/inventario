package com.krakedev.moduloii.evaluacionfinalm2.test;

import com.krakedev.moduloii.evaluacionfinalm2.entidades.Libros;
import com.krakedev.moduloii.evaluacionfinalm2.utils.ConexionBDD;
import com.krakedev.moduloii.evaluacionfinalm2.utils.Convertidor;

public class testInsertar {
	public static void main(String[] args) {
		
		String fechaS="2025/04/03";
		
		ConexionBDD conx = new ConexionBDD();
		
		Libros lib = null;
		try {
			
			lib = new Libros("Elibro nuevo", 1, 1,Convertidor.convertirAFecha(fechaS),true);
			conx.insertar(lib);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
