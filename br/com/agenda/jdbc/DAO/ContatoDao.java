package br.com.agenda.jdbc.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.agenda.jdbc.connection.ConnectionFactory;
import br.com.agenda.jdbc.modelo.Contato;

public class ContatoDao {
	// a conexão com o banco de dados
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome, email, endereco, dataNascimento) " + "values (?,?,?,?)";

		try {
			// Prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		try {

			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando data atraves da calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// Adiciona objeto a lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public List<Contato> getListapnome(String nome) {
		try {

			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from contatos " + " where nome like ? ");
			// resultado = comando.executeQuery("select nome,Id from aluno where
			// endereco_residencial like "%'+ t5.getText() +"' ");
			stmt.setString(1, nome + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto contato
				Contato contato = new Contato();
				stmt.setString(1, contato.getNome());
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando data atraves da calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// Adiciona objeto a lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public List<Contato> getListaID(String id) {
		try {

			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos " + " where id = ? ");
			// resultado = comando.executeQuery("select nome,Id from aluno where
			// endereco_residencial like "%'+ t5.getText() +"' ");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto contato
				Contato contato = new Contato();
				stmt.setString(1, contato.getNome());
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando data atraves da calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// Adiciona objeto a lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome = ?, email = ?, endereco = ?, " + "dataNascimento = ? where id = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			// seta valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id = ?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
