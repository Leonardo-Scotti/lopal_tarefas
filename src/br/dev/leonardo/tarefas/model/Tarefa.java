package br.dev.leonardo.tarefas.model;

import br.dev.leonardo.tarefas.utils.Utils;

public class Tarefa {
	private String tituloTarefa;
	private String descricaoTarefa;
	private String dataInicial;
	private int prazoTarefa;
	private String dataConclusao;
	private String statusTarefa;
	private String responsavelTarefa;
	private String codigo;

	public Tarefa() {
		this.codigo = Utils.gerarUUID8();
	}

	public Tarefa(String tituloTarefa, String descricaoTarefa, String dataInicial, int prazoTarefa,
			String dataConclusao, String statusTarefa, String responsavelTarefa) {
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataInicial = dataInicial;
		this.prazoTarefa = prazoTarefa;
		this.dataConclusao = dataConclusao;
		this.statusTarefa = statusTarefa;
		this.responsavelTarefa = responsavelTarefa;
		this.codigo = Utils.gerarUUID8();
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

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public int getPrazoTarefa() {
		return prazoTarefa;
	}

	public void setPrazoTarefa(int prazoTarefa) {
		this.prazoTarefa = prazoTarefa;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	public String getResponsavelTarefa() {
		return responsavelTarefa;
	}

	public void setResponsavelTarefa(String responsavelTarefa) {
		this.responsavelTarefa = responsavelTarefa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		String tarefa = tituloTarefa + "," + descricaoTarefa + "," + dataInicial + "," + prazoTarefa + ","
				+ dataConclusao + "," + statusTarefa + "," + responsavelTarefa + "," + codigo + "\n";
		return tarefa;
	}

}
