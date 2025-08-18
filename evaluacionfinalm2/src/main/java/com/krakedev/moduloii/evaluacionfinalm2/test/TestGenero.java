package com.krakedev.moduloii.evaluacionfinalm2.test;

import com.krakedev.moduloii.evaluacionfinalm2.entidades.Generos;
import com.krakedev.moduloii.evaluacionfinalm2.utils.ConexionBDD;

public class TestGenero {

	public static void main(String[] args) {
		

		ConexionBDD conx = new ConexionBDD();
		
		Generos genero = null;
		try {
			
			genero = new Generos("ficucion");
			conx.agregarGenero(genero);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
