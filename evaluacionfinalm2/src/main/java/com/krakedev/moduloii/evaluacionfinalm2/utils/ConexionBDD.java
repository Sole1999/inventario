package com.krakedev.moduloii.evaluacionfinalm2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.moduloii.evaluacionfinalm2.entidades.Generos;
import com.krakedev.moduloii.evaluacionfinalm2.entidades.Libros;
import com.krakedev.moduloii.evaluacionfinalm2.entidades.Prestamos;
import com.krakedev.moduloii.evaluacionfinalm2.excepciones.InventarioException;

public class ConexionBDD {

	public void insertar(Libros libro) throws InventarioException {

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres",
					"Postgresql.");
			System.out.println("conexion exitosa");

			ps = connection.prepareStatement(
					"INSERT INTO libros(titulo, autor_id, genero_id, anio_publicacion, estado_disponible)"
							+ "	VALUES (?,?,?,?,?)");

			ps.setString(1, libro.getTitulo());
			ps.setInt(2, libro.getAutor_id());
			ps.setInt(3, libro.getGenero_id());
			ps.setDate(4, new java.sql.Date(libro.getAnio_publicacion().getTime()));
			ps.setBoolean(5, libro.isEstado_disponible());
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void agregarGenero(Generos genero) throws InventarioException {

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres",
					"Postgresql.");
			System.out.println("conexion exitosa");

			ps = connection.prepareStatement("INSERT INTO generos(nombre)"

					+ "	VALUES (?)");

			ps.setString(1, genero.getNombre());

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public  void agregarPrestamo(Prestamos prestamo) throws InventarioException {

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres",
					"Postgresql.");
			System.out.println("conexion exitosa");

			ps = connection
					.prepareStatement("INSERT INTO prestamos(libro_id, fecha_prestamo, fecha_devolucion, usuario)"

							+ "	VALUES (?,?,?,?)");

			ps.setInt(1, prestamo.getLibro_id());
			ps.setDate(2, new java.sql.Date(prestamo.getFecha_prestamo().getTime()));
			ps.setDate(3, new java.sql.Date(prestamo.getFecha_devolucion().getTime()));
			ps.setString(4, prestamo.getUsuario());

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public  ArrayList<Prestamos> consultarPrestamos(int idLibro) throws InventarioException {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//Articulo art = null;
		Prestamos p;
		ArrayList<Prestamos> perstamos = new ArrayList<Prestamos>();
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres",
					"Postgresql.");
			System.out.println("conexion exitosa");

			ps = connection.prepareStatement("select * from prestamos where libro_id = ?");

			ps.setInt(1, idLibro);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("libro_id");
				Date dia = rs.getDate("fecha_prestamo");
				Date dia2 = rs.getDate("fecha_devolucion");
				String nombre = rs.getString("usuario");
				p = new Prestamos(id, dia, dia2, nombre);
				perstamos.add(p);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return perstamos;
	}

	public void eliminarGenero(int id_genero) throws InventarioException {

		Connection connection = null;
		PreparedStatement ps = null;
		//ResultSet rs = null;
		//Prestamos p;
		//ArrayList<Prestamos> perstamos = new ArrayList<Prestamos>();

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres",
					"Postgresql.");
			System.out.println("conexion exitosa");

			ps = connection.prepareStatement(
					"UPDATE libros SET genero_id=7 WHERE genero_id = ?;" + "DELETE FROM generos WHERE id_genero = ?;");

			ps.setInt(1, id_genero);
			ps.setInt(2, id_genero);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}
