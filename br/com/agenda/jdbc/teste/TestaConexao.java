package br.com.agenda.jdbc.teste;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.agenda.jdbc.connection.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection  = (Connection) new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta! ");
		connection.close();
		//System.out.println("Conexão Fechada!");

	}

}
