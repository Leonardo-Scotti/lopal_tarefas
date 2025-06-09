package br.dev.leonardo.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			ff.getBufferedWriterFuncionario().write(funcionario.toString());
			ff.getBufferedWriterFuncionario().flush();
			System.out.println("Funcionário gravado com sucesso!");

		} catch (IOException erro) {
			erro.printStackTrace();
		}

	}

	public List<Funcionario> listar() {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderFuncionario();

			String linha = "";

			br.readLine();

			while (linha != null) {
				// Extraíndo uma linha do arquivo
				linha = br.readLine();
				
				if (linha != null) {
					// Criando uma vetor
					String funcionarioStr[] = linha.split(",");

					// Criando um objeto funcionário
					Funcionario funcionario = new Funcionario();
					funcionario.setMatricula(funcionarioStr[0]);
					funcionario.setNome(funcionarioStr[1]);
					funcionario.setCargo(funcionarioStr[2]);
					double salario = Double.parseDouble(funcionarioStr[3]);
					funcionario.setSalario(salario);

					// Adicionando funcionários na lista
					funcionarios.add(funcionario);
				}
			}

			return funcionarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
