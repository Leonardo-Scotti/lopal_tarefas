package br.dev.leonardo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	private JComboBox<Status> comboStatus = new JComboBox<Status>(Status.values());
	private JLabel labelResponsavel;
	private JComboBox<String> comboResponsavel = new JComboBox<>();
	private JButton btnCadastrar;
	private JButton btnSair;
	
	public FrameTarefa() {
		
	}
	
	public FrameTarefa(JDialog jd) {
		criarTela(jd);
	}
	
	public void criarTela(JDialog jd) {
		JDialog tela = new JDialog(jd, true);
		tela.setSize(330, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(jd);
		tela.setTitle("Cadastro e Tarefas");
		
		//TÍTULO
		labelTitulo = new JLabel("Titulo");
		labelTitulo.setBounds(20, 20, 200, 30);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 45, 200, 20);
		
		//DESCRIÇÃO
		labelDescricao = new JLabel("Descrição");
		labelDescricao.setBounds(20, 65, 200, 30);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 90, 200, 20);
		
		//DATA INÍCIO
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
		
		//PRAZO
		labelPrazo = new JLabel("Prazo (em dias):");
		labelPrazo.setBounds(200, 110, 200, 30);
		
		txtPrazo = new JTextField();
		txtPrazo.setBounds(200, 135, 100, 20);
		
		//DATA CONCLUSÃO
		labelDataConclusao = new JLabel("Data de Conclusão:");
		labelDataConclusao.setBounds(20, 155, 200, 30);
		
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(20, 180, 200, 20);
		txtDataConclusao.enable(false);
		
		//STATUS
		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(20, 200, 200, 30);
		
		comboStatus.setBounds(20, 225, 200, 20);
		
		String statusSelecionado = (String) comboStatus.getSelectedItem();
		
		//RESPONSÁVEL
		labelResponsavel = new JLabel("Responsável:");
		labelResponsavel.setBounds(20, 245, 200, 30);
		
		comboResponsavel.setBounds(20, 270, 200, 20);
		
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		String[][] responsaveis = new String[funcionarios.size()][1];
		int i = 0;
		for (Funcionario f : funcionarios) {
			responsaveis[0][0] = f.getNome();
			i++;
			
			comboResponsavel.addItem(responsaveis[0][0]);
		}
		
		String responsavelSelecionado = (String) comboResponsavel.getSelectedItem();
		
		//BOTÃO CADASTRAR
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(60, 320, 100, 30);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
			            // Coletando dados do formulário
			            String titulo = txtTitulo.getText();
			            String descricao = txtDescricao.getText();
			            
			            // Criando data a partir dos campos dia/mês/ano
			            int dia = Integer.parseInt(txtDia.getText());
			            int mes = Integer.parseInt(txtMes.getText());
			            int ano = Integer.parseInt(txtAno.getText());
			            LocalDate dataInicial = LocalDate.of(ano, mes, dia);
			            
			            int prazo = Integer.parseInt(txtPrazo.getText());
			            Status status = (Status) comboStatus.getSelectedItem();
			            String responsavel = (String) comboResponsavel.getSelectedItem();
			            
			            // Criando e configurando a tarefa
			            Tarefa tarefa = new Tarefa();
			            tarefa.setTituloTarefa(titulo);
			            tarefa.setDescricaoTarefa(descricao);
			            tarefa.setDataInicial(dataInicial);
			            tarefa.setPrazoTarefa(prazo);
			            tarefa.setStatusTarefa(status.toString());
			            tarefa.setResponsavelTarefa(responsavel);
			            
			            // Calculando e setando a data de conclusão
			            LocalDate dataConclusao = dataInicial.plusDays(prazo);
			            tarefa.setDataConclusao(dataConclusao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			            
			            // Atualizando o campo visual (opcional)
			            txtDataConclusao.setText(dataConclusao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			            
			            // Gravando no banco de dados
			            TarefaDAO dao = new TarefaDAO(tarefa);
			            dao.gravar();
			            
			            JOptionPane.showMessageDialog(tela, "Tarefa cadastrada com sucesso!");
			            tela.dispose();
			            
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(tela, "Por favor, preencha todos os campos corretamente!", 
				
			
			}
		});
		
		//BOTÃO SAIR
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
}
