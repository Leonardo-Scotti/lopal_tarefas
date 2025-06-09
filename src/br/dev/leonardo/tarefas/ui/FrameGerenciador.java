package br.dev.leonardo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameGerenciador {
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	public FrameGerenciador() {
		criarTela();
	}
	
	public void criarTela() {
		//Objeto da tela
		JFrame tela = new JFrame();
		tela.setSize(500, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Gerenciador de Tarefas");
		tela.setResizable(false);
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(40, 40, 190, 70);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FrameFuncionarioList(tela);
			}
		});
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(240, 40, 190, 70);
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FrameTarefasList(tela);
			}
		});
		
		Container painel = tela.getContentPane();
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		tela.setVisible(true);
	}
}
