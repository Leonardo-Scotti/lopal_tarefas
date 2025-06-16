package br.dev.leonardo.tarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.dev.leonardo.tarefas.utils.Utils;

public class Tarefa {
	private String tituloTarefa;
	private String descricaoTarefa;
	private LocalDate dataInicial;
	private int prazoTarefa;
	private LocalDate dataConclusao;
	private String statusTarefa;
	private String responsavelTarefa;
	private String codigo;

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

	public void setDataInicial(String dataInicial) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.dataInicial = LocalDate.parse(dataInicial, formato);
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

	public void setDataConclusao(String dataConclusao) {
		LocalDate dataCalc = calcularDataConclusao();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dataFormatada = dataCalc.format(formato);
		
		
		this.dataConclusao = LocalDate.parse(dataFormatada, formato);
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

	public LocalDate calcularDataConclusao() {
        if (prazoTarefa > 0) {
            this.dataConclusao = dataInicial.plusDays(prazoTarefa);
        }
        return this.dataConclusao;
    }

	@Override
	public String toString() {
		String tarefa = tituloTarefa + "," + descricaoTarefa + "," + dataInicial + "," + prazoTarefa + ","
				+ dataConclusao + "," + statusTarefa + "," + responsavelTarefa + "," + codigo;
		return tarefa;
	}

}
