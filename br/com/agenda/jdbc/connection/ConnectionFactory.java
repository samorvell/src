package br.com.agenda.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://192.168.0.100:3306/javaweb", "samuel", "281211");
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
