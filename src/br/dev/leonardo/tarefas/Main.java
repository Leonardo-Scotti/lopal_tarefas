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
		
		new FrameGerenciador();
	}

}
