package br.dev.leonardo.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.leonardo.tarefas.factory.FileFactory;
import br.dev.leonardo.tarefas.model.Tarefa;

public class TarefaDAO {
	private Tarefa tarefa;

	public TarefaDAO() {
		
	}
	
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriterTarefa().write(tarefa.toString());
			ff.getBufferedWriterTarefa().flush();
			System.out.println("Tarefa Cadastrada");
		} catch (IOException erro) {
			// TODO: handle exception
			erro.printStackTrace();
		}
	}

	public List<Tarefa> listar() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderTarefa();

			String linha = "";

			br.readLine();

			while (linha != null) {
				linha = br.readLine();

				if (linha != null) {
					// Criando o Vetor
					String[] tarefasStr = linha.split(",");
					String titulo = tarefasStr[0];
					String descricao = tarefasStr[1];
					String dataInicial = tarefasStr[2];
					int prazo = Integer.parseInt(tarefasStr[3]);
					String dataConclusao = tarefasStr[4];
					String status = tarefasStr[5];
					String responsavel = tarefasStr[6];

					// Criando um objeto Tarefa
					Tarefa tarefa = new Tarefa();
					tarefa.setTituloTarefa(titulo);
					tarefa.setDescricaoTarefa(descricao);
					tarefa.setDataInicial(dataInicial);
					tarefa.setPrazoTarefa(prazo);
					tarefa.setStatusTarefa(status);
					tarefa.setResponsavelTarefa(responsavel);

					// Adicionando Funcionários na lista
					tarefas.add(tarefa);
				}
			}
			return tarefas;
		} catch (IOException erro) {
			erro.printStackTrace();
			return null;
		}
	}
}
