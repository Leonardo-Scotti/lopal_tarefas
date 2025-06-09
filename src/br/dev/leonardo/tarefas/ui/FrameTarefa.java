package br.dev.leonardo.tarefas.ui;

import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameTarefa {
	private JLabel labelTitulo;
	private JTextField txtTitulo;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelDataInicial;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAno;
	
	
	
	public FrameTarefa(JDialog jd) {
		criarTela(jd);
	}
	
	public void criarTela(JDialog jd) {
		JDialog tela = new JDialog(jd, true);
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(jd);
		
		
		
		
		Container painel = tela.getContentPane();
		
		
		tela.setVisible(true);
	}
}
