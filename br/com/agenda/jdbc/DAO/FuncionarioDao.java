package br.com.agenda.jdbc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.agenda.jdbc.connection.ConnectionFactory;
import br.com.agenda.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	// a conexão com o banco de dados
	private Connection connection;
	
	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	public void adiciona (Funcionario funcionario) {
		String sql = "insert into funcionarios " + "(nome, usuario, senha ) " + "values (?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
