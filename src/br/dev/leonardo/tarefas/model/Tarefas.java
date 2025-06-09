package br.dev.leonardo.tarefas.model;

import java.time.LocalDate;

import br.dev.leonardo.tarefas.utils.Utils;

public class Tarefas {
	private String tituloTarefa;
	private String descricaoTarefa;
	private LocalDate dataInicial;
	private int prazoTarefa;
	private LocalDate dataConclusao;
	private Status statusTarefa;
	private Funcionario responsavelTarefa;
	private int código;
	
	public void Tarefas(String tituloTarefa, String descricaoTarefa, LocalDate dataInicial, int prazoTarefa, Status statusTarefa, Funcionario responsavelTarefa) {
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataInicial = dataInicial;
		this.prazoTarefa = prazoTarefa;
		this.statusTarefa = statusTarefa;
		this.responsavelTarefa = responsavelTarefa;
		this.código = Utils.gerarUUID8();
	}
	
	
	public String getTituloTarefa() {
		return tituloTarefa;
	}

	public void setTituloTarefa(String tituloTarefa) {
		this.tituloTarefa = tituloTarefa;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public int getPrazoTarefa() {
		return prazoTarefa;
	}

	public void setPrazoTarefa(int prazoTarefa) {
		this.prazoTarefa = prazoTarefa;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Status getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(Status statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	public Funcionario getResponsavelTarefa() {
		return responsavelTarefa;
	}

	public void setResponsavelTarefa(Funcionario responsavelTarefa) {
		this.responsavelTarefa = responsavelTarefa;
	}

}
