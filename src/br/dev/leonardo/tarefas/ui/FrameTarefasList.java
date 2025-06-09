package br.dev.leonardo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.leonardo.tarefas.dao.TarefaDAO;
import br.dev.leonardo.tarefas.model.Tarefa;

public class FrameTarefasList {
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	private DefaultTableModel modelTarefas;
	private JButton btnCadastrar;
	private JButton btnSair;
	private String[] colunas = {"CÓDIGO", "NOME", "RESPONSÁVEL"};
	
	public FrameTarefasList(JFrame jf) {
		criarTela(jf);
	}
	
	public void criarTela(JFrame jf) {
		//Criando o objeto da Tela
		JDialog tela = new JDialog(jf, true);
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(jf);
		tela.setTitle("Lista de Tarefas");
		tela.setResizable(false);
		
		modelTarefas = new DefaultTableModel(colunas, 20) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabelaTarefas = new JTable(modelTarefas);
		tabelaTarefas.getTableHeader().setReorderingAllowed(false);
		
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 30, 460, 343);
		
		carregarDados();
		
		btnCadastrar = new JButton("Nova Tarefa");
		btnCadastrar.setBounds(10, 400, 200, 40);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa(tela);
				carregarDados();
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(230, 400, 100, 40);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int resposta = JOptionPane.showConfirmDialog(tela, "Você tem certeza que deseja sair?");
				if (resposta == 0) {
					tela.dispose();
				}
				
			}
		});
		
		
		Container painel = tela.getContentPane();
		painel.add(scrollTarefas);
		painel.add(btnCadastrar);
		painel.add(btnSair);
		
		tela.setVisible(true);
	}
	
	private void carregarDados() {
		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> tarefas = dao.listar();
		
		Object[][] dados = new Object[tarefas.size()][3];
		int i = 0;
		for (Tarefa t : tarefas) {
			dados[i][0] = t.getTituloTarefa();
			dados[i][6] = t.getResponsavelTarefa();
			dados[i][8] = t.getCodigo();
		}
		
		modelTarefas.setDataVector(dados, colunas);
	}
}
