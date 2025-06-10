package br.dev.leonardo.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	private String arquivoFuncionario = "C:\\Users\\25132821\\ProjetoTarefas\\funcionarios.csv";
	private String arquivoTarefa = "C:\\Users\\25132821\\ProjetoTarefas\\tarefas.csv";

	//Funcionario
	private FileWriter fwf;
	private BufferedWriter bwf;
	
	private FileReader frf;
	private BufferedReader brf;
	
	//Tarefa
	private FileWriter fwt;
	private BufferedWriter bwt;
	
	private FileReader frt;
	private BufferedReader brt;

	public FileFactory() throws IOException {
		//Necessário para escrever no arquivo
		fwf = new FileWriter(arquivoFuncionario, true);
		bwf = new BufferedWriter(fwf);
		
		//Necessário para ler o arquivo
		frf = new FileReader(arquivoFuncionario);
		brf = new BufferedReader(frf);
		
		//Tarefas
		fwt = new FileWriter(arquivoTarefa, true);
		bwt = new BufferedWriter(fwt);
		
		frt = new FileReader(arquivoTarefa);
		brt = new BufferedReader(frt);
	}
	
	//Funcionario
	public BufferedWriter getBufferedWriterFuncionario() {
		return bwf;
	}
	
	public BufferedReader getBufferedReaderFuncionario() {
		return brf;
	}
	
	//Tarefa
	public BufferedWriter getBufferedWriterTarefa() {
		return bwt;
	}
	
	public BufferedReader getBufferedReaderTarefa() {
		return brt;
	}

}
