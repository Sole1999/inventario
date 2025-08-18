package com.krakedev.moduloii.evaluacionfinalm2.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Convertidor {
	private static final String FORMATO_FECHA = "yyyy/MM/dd";
	private static final String FORMATO_HORA = "hh:mm";
	//private static final Logger LOGGER = LogManager.getLogger(Convertidor.class);
	
	public static Date convertirAFecha(String fechaStr) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		//String fechaStr = "2020/03/22 10:05:04";
		Date fechaDate = null;
		//LOGGER.trace("Convirtiendo la fecha: "+fechaStr);
		fechaDate = sdf.parse(fechaStr);
		//LOGGER.trace("Fecha convertida: "+fechaDate);
		return fechaDate;
	}
	
	public static Date convertirAHora(String horaStr) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_HORA);
		
		Date horaDate = null;
		//LOGGER.trace("Convirtiendo la hora: "+horaStr);
		horaDate = sdf.parse(horaStr);
		//LOGGER.trace("Hora convertida: "+horaDate);
		return horaDate;
	}
}
