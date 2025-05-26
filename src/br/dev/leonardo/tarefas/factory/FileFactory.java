package br.dev.leonardo.tarefas.factory;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	private String arquivo = "C:\\Users\\25132821\\ProjetoTarefas\\funcionarios.csv";

	private FileWriter fw;
	private BufferedWriter bw;

	public FileFactory() throws IOException {
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);

	}
	
	public BufferedWriter getBufferedWriter() {
		return bw;
	}

}
