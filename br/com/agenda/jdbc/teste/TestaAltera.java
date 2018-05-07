package br.com.agenda.jdbc.teste;

import java.util.Calendar;

import br.com.agenda.jdbc.DAO.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
				//pronto para gravar
				Contato contato = new Contato();
				long id = 3;
				contato.setId(id);
				//contato.setId(002);
				contato.setNome("Rafaella de Santana Silva");
				contato.setEmail("rafa.silva@hotmail.com.br");
				contato.setEndereco("Rua das casas");
				contato.setDataNascimento(Calendar.getInstance());
				
				//grava nessa conexão
				ContatoDao dao = new ContatoDao();
				//metodo elegante
				dao.altera (contato);
				System.out.println("Alterado! ");

	}		

}

