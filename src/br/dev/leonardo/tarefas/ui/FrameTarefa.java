package br.dev.leonardo.tarefas.ui;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.leonardo.tarefas.dao.FuncionarioDAO;
import br.dev.leonardo.tarefas.dao.TarefaDAO;
import br.dev.leonardo.tarefas.model.Funcionario;
import br.dev.leonardo.tarefas.model.Status;
import br.dev.leonardo.tarefas.model.Tarefa;

public class FrameTarefa {
	private JLabel labelTitulo;
	private JTextField txtTitulo;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelDataInicial;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAno;
	private JComboBox<Status> comboStatus = new JComboBox<Status>(Status.values());
	private JComboBox<String> comboResponsavel = new JComboBox<>();
	
	public FrameTarefa() {
		
	}
	
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
		tela.setTitle("Cadastro e Tarefas");
		
		labelTitulo = new JLabel("Titulo");
		labelTitulo.setBounds(20, 20, 200, 30);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 50, 200, 30);
		
		labelDescricao = new JLabel("Descrição");
		labelDescricao.setBounds(20, 85, 200, 30);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 115, 200, 30);
		
		labelDataInicial = new JLabel("Data de Início");
		labelDataInicial.setBounds(20, 150, 200, 30);
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		//painel.add(labelDescricao);
		
		tela.setVisible(true);
	}
	
	public static List<String> extrairColuna(String[][] funcionarios, int indiceColuna) {
        List<String> colunaNome = new ArrayList<>();
        
        for (String[] linha : funcionarios) {
            if (linha.length > indiceColuna) { // Verifica se a coluna existe
                colunaNome.add(linha[indiceColuna]);
            }
        }
        return colunaNome;
    }
}
