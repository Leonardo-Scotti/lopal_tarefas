package br.dev.leonardo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.leonardo.tarefas.dao.FuncionarioDAO;
import br.dev.leonardo.tarefas.model.Funcionario;

public class FrameFuncionario {
	
	private JLabel labelMatricula;
	private JLabel labelNome;
	private JLabel labelCargo;
	private JLabel labelSalario;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSalario;
	private JButton btnSalvar;	
	private JButton btnSair;
	
	public FrameFuncionario(JDialog jd) {
		criarTela(jd);
		
	}
	
	private void criarTela(JDialog jd) {
		JDialog tela = new JDialog(jd, true);
		tela.setTitle("Cadastro");
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(jd);
		
		Container painel = tela.getContentPane();
		
		//Matricula
		labelMatricula = new JLabel("Matrícula:");
		labelMatricula.setBounds(10, 10, 200, 30);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 40, 150, 30);
		txtMatricula.setEnabled(false);
		
		//Nome
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 75, 200, 30);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 105, 365, 30);
		
		//Cargo
		labelCargo = new JLabel("Cargo:");
		labelCargo.setBounds(10, 140, 200, 30);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(10, 170, 300, 30);
		
		//Salário
		labelSalario = new JLabel("Salário:");
		labelSalario.setBounds(10, 205, 150, 30);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(10, 235, 150, 30);
		
		//Botão Salvar
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 300, 120, 50);
		
		//Botão Sair
		btnSair = new JButton("Sair");
		btnSair.setBounds(140, 300, 80, 50);
		
		painel.add(labelMatricula);
		painel.add(txtMatricula);
		painel.add(labelNome);
		painel.add(txtNome);
		painel.add(labelCargo);
		painel.add(txtCargo);
		painel.add(labelSalario);
		painel.add(txtSalario);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cargo = txtCargo.getText();
				String nome = txtNome.getText();
				double salario = Double.parseDouble(txtSalario.getText());
				
				Funcionario f = new Funcionario(cargo, nome, salario);
				
				FuncionarioDAO dao = new FuncionarioDAO(f);
				dao.gravar();
				
				JOptionPane.showMessageDialog(tela,nome + "\ncadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				limparFormulário();
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int resposta = JOptionPane.showConfirmDialog(tela, "Você tem certeza que deseja sair do cadastro?");
				
				if (resposta == 0) {
					tela.dispose();
				}
				
			}
		});
		
		tela.setVisible(true);
		
	}
	
	public void limparFormulário() {
		txtNome.setText(null);
		txtNome.requestFocus();
		txtCargo.setText(null);
		txtSalario.setText(null);
	}

}
