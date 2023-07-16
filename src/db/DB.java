package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	// endereço do banco
	private static String stringConnection = "jdbc:mysql://localhost:3306/ouvidoria_fase3";

	// usuário e senha de conexão
	private static String usuario = "root";
	private static String passoword = "12345";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(stringConnection, usuario, passoword);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		}
	
		public void closeConnection (Connection con) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


