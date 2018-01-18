package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bd_tutorial";
			String usr = "root";
			//String psw = "RARO97";
			String psw = "";//

			
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error");
		} catch (SQLException e) {
			System.out.println("Error con la  conexión de BD");
		}
		return con;
	}
}