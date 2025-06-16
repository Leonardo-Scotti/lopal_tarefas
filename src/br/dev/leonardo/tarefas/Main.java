package br.dev.leonardo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.dev.leonardo.tarefas.dao.FuncionarioDAO;
import br.dev.leonardo.tarefas.model.Funcionario;
import br.dev.leonardo.tarefas.model.Status;
import br.dev.leonardo.tarefas.model.Tarefa;
import br.dev.leonardo.tarefas.ui.FrameFuncionario;
import br.dev.leonardo.tarefas.ui.FrameFuncionarioList;
import br.dev.leonardo.tarefas.ui.FrameGerenciador;
import br.dev.leonardo.tarefas.ui.FrameTarefa;
import br.dev.leonardo.tarefas.ui.FrameTarefasList;
import br.dev.leonardo.tarefas.utils.Utils;

public class Main {
	private static String path = "c:\\Users\\25132821\\ProjetoTarefas\\tarefas.csv";

	public static void main(String[] args) {
//		
//		Tarefa t = new Tarefa("Teste", "teste", LocalDate.now(), 3, "Não Iniciado", "Responsável teste");
//		
//		System.out.println(t.toString());
		
//		new FrameGerenciador();
		
		new FrameTarefa();
//		new FrameFuncionarioList();

//		FuncionarioDAO dao = new FuncionarioDAO();
//		List<Funcionario> funcionarios = dao.listar();
//
//		for (Funcionario f : funcionarios) {
//			System.out.println(f.getNome());
//			System.out.println(f.getCargo());
//			System.out.println("----------");
//		}

//	new FrameFuncionario();

	}

//	private static void gravarArquivo() {
//		
//		FileWriter fw = null;
//		BufferedWriter bw = null;
//		
//		try {
//			fw = new FileWriter(path, true);
//			bw = new BufferedWriter(fw);
//			
//			String novaLinha = "Isso é uma nova linha! \n";
//			String novaLinha2 = "Isso é uma nova linha2! \n";
//			String novaLinha3 = "Isso é uma nova linha3! \n";
//			
//			bw.write(novaLinha);
//			bw.write(novaLinha2);
//			bw.write(novaLinha3);
//			bw.flush();
//			
//		} catch (Exception erro) {
//			System.out.println(erro.getMessage());
//		}
//		
//	}
//	
//	private static void lerArquivo() {
//		FileReader fr = null;
//		BufferedReader br = null;
//		
//		
//		try {
//			fr = new FileReader(path);
//			br = new BufferedReader(fr);
//			
//			String linha = br.readLine();
//			
//			while (linha != null) {
//				String[] registro = linha.split(";");
//				System.out.println("Nome: " + registro[0]);
//				System.out.println("Tarefa: " + registro[1]);
//				System.out.println("------------------------");
//				linha = br.readLine();
//			}
//			
//		} catch (FileNotFoundException erro) {
//			System.out.println(erro.getMessage());
//		} catch (IOException erro) {
//			System.out.println(erro.getMessage());
//		}catch (Exception erro) {
//			System.out.println(erro.getMessage());
//		}
//	}

}
