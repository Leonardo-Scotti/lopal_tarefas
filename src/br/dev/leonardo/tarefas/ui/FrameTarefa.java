package br.dev.leonardo.tarefas.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.dev.leonardo.tarefas.dao.FuncionarioDAO;
import br.dev.leonardo.tarefas.dao.TarefaDAO;
import br.dev.leonardo.tarefas.model.Funcionario;
import br.dev.leonardo.tarefas.model.Status;
import br.dev.leonardo.tarefas.model.Tarefa;
import br.dev.leonardo.tarefas.utils.Utils;

public class FrameTarefa {
	private JLabel labelTitulo;
	private JTextField txtTitulo;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelDataInicial;
	private JTextField txtDia;
	private JLabel barDia;
	private JTextField txtMes;
	private JLabel barMes;
	private JTextField txtAno;
	private JLabel labelPrazo;
	private JTextField txtPrazo;
	private JLabel labelDataConclusao;
	private JTextField txtDataConclusao;
	private JLabel labelStatus;
	private JComboBox<Status> comboStatus;
	private JLabel labelResponsavel;
	private JComboBox<String> comboResponsavel;
	private JButton btnCadastrar;
	private JButton btnSair;
	private String dataInicial = "";
	private JDialog tela;

	// VARIÁVEIS PARA GUARDAR O STATUS E O RESPONSÁVEL
	private Status statusSelecionado;
	private String responsavelSelecionado;

	public FrameTarefa() {

	}

	public FrameTarefa(JDialog jd) {
		criarTela(jd);
	}

	private void criarTela(JDialog jd) {
		tela = new JDialog(jd, true);
		tela.setSize(330, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(jd);
		tela.setTitle("Cadastro e Tarefas");

		// ==========TÍTULO==========
		labelTitulo = new JLabel("Titulo");
		labelTitulo.setBounds(20, 20, 200, 30);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 45, 200, 20);

		// ==========DESCRIÇÃO==========
		labelDescricao = new JLabel("Descrição");
		labelDescricao.setBounds(20, 65, 200, 30);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 90, 200, 20);

		// ==========DATA INÍCIO==========
		labelDataInicial = new JLabel("Data de Início");
		labelDataInicial.setBounds(20, 110, 200, 30);

		txtDia = new JTextField();
		txtDia.setBounds(20, 135, 30, 20);

		barDia = new JLabel("/");
		barDia.setBounds(55, 135, 30, 20);

		txtMes = new JTextField();
		txtMes.setBounds(65, 135, 30, 20);

		barMes = new JLabel("/");
		barMes.setBounds(100, 135, 30, 20);

		txtAno = new JTextField();
		txtAno.setBounds(110, 135, 40, 20);
		
		carregarDataInicial();

		// PRAZO
		labelPrazo = new JLabel("Prazo (em dias):");
		labelPrazo.setBounds(200, 110, 200, 30);

		txtPrazo = new JTextField();
		txtPrazo.setBounds(200, 135, 100, 20);
		
		txtPrazo.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				calcularDataConclusao();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				calcularDataConclusao();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				calcularDataConclusao();
			}
		});

		// DATA CONCLUSÃO
		labelDataConclusao = new JLabel("Data de Conclusão:");
		labelDataConclusao.setBounds(20, 155, 200, 30);

		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(20, 180, 200, 20);
		txtDataConclusao.enable(false);

		// STATUS
		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(20, 200, 200, 30);

		comboStatus = new JComboBox<Status>();
		comboStatus.setBounds(20, 225, 200, 20);

		carregarStatus();

		// RESPONSÁVEL
		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(20, 245, 200, 30);

		comboResponsavel = new JComboBox<String>();
		comboResponsavel.setBounds(20, 270, 200, 20);
		carregarResponsavel();

		// BOTÃO CADASTRAR
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(60, 320, 100, 30);

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				responsavelSelecionado = (String) comboResponsavel.getSelectedItem();
				statusSelecionado = (Status) comboStatus.getSelectedItem();
				if (txtTitulo.getText().trim().isEmpty() || txtDescricao.getText().trim().isEmpty()
						|| txtDia.getText().trim().isEmpty() || txtMes.getText().trim().isEmpty()
						|| txtAno.getText().trim().isEmpty() || txtPrazo.getText().trim().isEmpty()
						|| responsavelSelecionado == null || statusSelecionado == null) {
					JOptionPane.showMessageDialog(tela, "*Todos os campos devem ser preenchidos!");
				} else {
					try {
						try {
						
						} catch (NumberFormatException erro) {
							JOptionPane.showMessageDialog(tela, "Preencha corretamente os campos da data de início!");
						}
						
						calcularDataConclusao();
					} catch (Exception e2) {
						// TODO: handle exception
					}

				}
			}
		});

		// BOTÃO SAIR
		btnSair = new JButton("Sair");
		btnSair.setBounds(180, 320, 60, 30);

		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		painel.add(txtDia);
		painel.add(barDia);
		painel.add(txtMes);
		painel.add(barMes);
		painel.add(txtAno);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataConclusao);
		painel.add(txtDataConclusao);
		painel.add(labelStatus);
		painel.add(comboStatus);
		painel.add(labelResponsavel);
		painel.add(comboResponsavel);
		painel.add(btnCadastrar);
		painel.add(btnSair);

		tela.setVisible(true);
	}

	private void carregarResponsavel() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();

		String[][] responsaveis = new String[funcionarios.size()][1];
		int i = 0;
		for (Funcionario f : funcionarios) {
			responsaveis[0][0] = f.getNome();
			i++;

			comboResponsavel.addItem(responsaveis[0][0]);
		}
	}

	private void carregarStatus() {
		Status[] status = Status.values();

		for (Status estado : status) {
			comboStatus.addItem(estado);
		}
	}
	
	private void carregarDataInicial() {
		String dia = txtDia.getText();
		String mes = txtMes.getText();
		String ano = txtAno.getText();
		
		dataInicial = dia + "/" + mes + "/" + ano;
	}

	private void calcularDataConclusao() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			// obter data inicial
			Date dateDataInicial = sdf.parse(dataInicial);

			// obter prazo e validar
			int prazo;
			try {
				prazo = Integer.parseInt(txtPrazo.getText());
				if (prazo < 0) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				txtDataConclusao.setText("");
				JOptionPane.showMessageDialog(tela, "O prazo deve ser um número inteiro positivo!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// calcular data de conclusão
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateDataInicial);
			cal.add(Calendar.DAY_OF_MONTH, prazo);

			txtDataConclusao.setText(sdf.format(cal.getTime()));

		} catch (java.text.ParseException e) {
			txtDataConclusao.setText("");
			JOptionPane.showMessageDialog(tela, "Digite a data no formato correto (dd/MM/aaaa)!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
