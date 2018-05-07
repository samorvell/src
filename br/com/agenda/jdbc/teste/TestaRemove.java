package br.com.agenda.jdbc.teste;

import br.com.agenda.jdbc.DAO.ContatoDao;
import br.com.agenda.jdbc.modelo.Contato;

public class TestaRemove {

	public static void main(String[] args) {
		//pronto para gravar
		Contato contato = new Contato();
		//grava nessa conexão
		ContatoDao dao = new ContatoDao();
		long id = 5;
		contato.setId(id);
		dao.remove(contato);
		System.out.println("Removido! ");
		
	}
	

}
