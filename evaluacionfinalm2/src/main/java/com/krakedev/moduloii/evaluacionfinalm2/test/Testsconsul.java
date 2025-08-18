package com.krakedev.moduloii.evaluacionfinalm2.test;

import java.util.ArrayList;

import com.krakedev.moduloii.evaluacionfinalm2.entidades.Prestamos;
import com.krakedev.moduloii.evaluacionfinalm2.utils.ConexionBDD;

public class Testsconsul {
	
	public static void main(String[] args) {
		
		ConexionBDD conx = new ConexionBDD();
		
		ArrayList<Prestamos> prestamos = new ArrayList<Prestamos>();
		

		try
		{
			prestamos = conx.consultarPrestamos(1);
			System.out.println(prestamos);
			
		}catch(
		Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	}
	
	
	
