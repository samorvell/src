package br.com.agenda.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.agenda.jdbc.DAO.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaListaPorNome {

	public static void main(String[] args) {
		// Criando o contato dao
		ContatoDao dao = new ContatoDao();
		String nome = "S";
		// listando contatos com DAO
		List<Contato> contatos = dao.getListapnome(nome);
		for (Contato contato : contatos) {
			//contato.setNome("T");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + sdf.format(contato.getDataNascimento().getTime()) + "\n");

		}
	}
}