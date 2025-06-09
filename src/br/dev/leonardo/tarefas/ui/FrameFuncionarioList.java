package br.dev.leonardo.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.leonardo.tarefas.dao.FuncionarioDAO;
import br.dev.leonardo.tarefas.model.Funcionario;

public class FrameFuncionarioList {

	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JButton btnSair;
	private JTable tabelaFuncionarios;
	private JScrollPane scrollFuncionarios;
	private DefaultTableModel modelFuncionarios;
	private String[] colunas = { "CÓDIGO", "NOME", "CARGO" };

	public FrameFuncionarioList(JFrame jf) {
		criarTela(jf);
	}

	public void criarTela(JFrame jf) {
		// Criando o objeto da Tela
		JDialog tela = new JDialog(jf, true);
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Lista de Funcionários");
		tela.setResizable(false);

		// Manipulando a Label Título
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		labelTitulo.setBounds(10, 10, 400, 40);

		// Criação da Tabela
		
		// Criando model
		modelFuncionarios = new DefaultTableModel(colunas, 20) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		// Criando Tabela
		tabelaFuncionarios = new JTable(modelFuncionarios);
		tabelaFuncionarios.getTableHeader().setReorderingAllowed(false);
		
		// Criando Scroll e adicionando a tabela nele
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 50, 460, 343);
		
		// Puxando dados do DB
		carregarDados();
		
		// Ajustando o Botão
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(10, 410, 200, 40);
		
		btnCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FrameFuncionario(tela);
				carregarDados();
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(220, 410, 100, 40);
		
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

		// Criando variável do container da tela
		Container painel = tela.getContentPane();
		// Adicionando componentes no container
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnCadastro);
		painel.add(btnSair);

		// "Setando" visibilidade da tela
		tela.setVisible(true);
	}
	
	private void carregarDados() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		int i = 0;
		for(Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		
		modelFuncionarios.setDataVector(dados, colunas);
	}

}
