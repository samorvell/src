package br.com.agenda.jdbc.teste;

import java.util.Calendar;

import br.com.agenda.jdbc.DAO.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		//pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Tste Silva");
		contato.setEmail("teste.silva@hotmail.com.br");
		contato.setEndereco("Rua dos teste 1");
		contato.setDataNascimento(Calendar.getInstance());
		
		//grava nessa conexão
		ContatoDao dao = new ContatoDao();
		//metodo elegante
		dao.adiciona (contato);
		System.out.println("Gravado! ");

	}

}
