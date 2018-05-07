package br.com.agenda.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.agenda.jdbc.DAO.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		//Criando o contato dao
		ContatoDao dao = new ContatoDao();
		//listando contatos com DAO
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Nome: "+ contato.getNome());
			System.out.println("Email: "+ contato.getEmail());
			System.out.println("Endereco: "+contato.getEndereco());
			//System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");
			
			
            //linha abaixo alterada para exibir a data no formato dd/MM/YYYY, retirado a linha de cima
            System.out.println("Data de Nascimento: " + sdf.format(contato.getDataNascimento().getTime()) + "\n");
		}

	}

}
