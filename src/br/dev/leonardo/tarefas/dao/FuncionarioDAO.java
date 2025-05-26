package br.dev.leonardo.tarefas.dao;

import java.io.IOException;

import br.dev.leonardo.tarefas.factory.FileFactory;
import br.dev.leonardo.tarefas.model.Funcionario;

public class FuncionarioDAO {
	private Funcionario funcionario;

	public FuncionarioDAO() {

	}

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(funcionario.toString());
			ff.getBufferedWriter().flush();
			System.out.println("Funcionário gravado com sucesso!");
			
		} catch (IOException erro) {
			// TODO Auto-generated catch block
			erro.printStackTrace();
		}
		
	}
}
