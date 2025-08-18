package com.krakedev.moduloii.evaluacionfinalm2.test;

import com.krakedev.moduloii.evaluacionfinalm2.utils.ConexionBDD;

public class TestEliminarGenero {

	public static void main(String[] args) {
		
		
		ConexionBDD conx = new ConexionBDD();
		

		try {
			
			
			conx.eliminarGenero(1);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}

	}

}
