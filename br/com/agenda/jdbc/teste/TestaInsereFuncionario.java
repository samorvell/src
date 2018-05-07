package br.com.agenda.jdbc.teste;




import br.com.agenda.jdbc.DAO.FuncionarioDao;
import br.com.agenda.jdbc.modelo.Funcionario;

public class TestaInsereFuncionario {

	public static void main(String[] args) {
			//pronto para gravar
			Funcionario funcionario = new Funcionario();
			funcionario.setNome("Teste Silva");
			funcionario.setUsuario("teste.silva");
			funcionario.setSenha("Rua dos teste 1");
			
			
			//grava nessa conexão
			FuncionarioDao dao = new FuncionarioDao();
			//metodo elegante
			dao.adiciona (funcionario);
			System.out.println("Gravado! ");

	}

}
