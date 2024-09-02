package br.com.alura.screematch.modelo;

import br.com.alura.screematch.dados.DadosEpisodio;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episodio {
	private Integer temporada;
	private String titulo;
	private Integer numeroEp;
	private Double avaliacao;
	private LocalDate dataLancamento;

	public Episodio(Integer numerodaTemporada, DadosEpisodio dadosEpisodio){
		this.titulo = dadosEpisodio.getTitulo();
		this.temporada = numerodaTemporada;
		this.numeroEp = dadosEpisodio.getnEpisodio();

		try {
		this.dataLancamento = LocalDate.parse(dadosEpisodio.getDataLancamento());
		}
		catch (NullPointerException e){
			dataLancamento = null;
		}
		catch (DateTimeException e){
			dataLancamento = null;
		}

		try {
		this.avaliacao = Double.valueOf(dadosEpisodio.getAvalicao());
		}
		catch (NumberFormatException e ){
			avaliacao = null;
		}
	}


	public Integer getTemporada() {
		return temporada;
	}

	public void setTemporada(Integer temporada) {
		this.temporada = temporada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumeroEp() {
		return numeroEp;
	}

	public void setNumeroEp(Integer numeroEp) {
		this.numeroEp = numeroEp;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	@Override
	public String toString() {
		return
				" temporada = " + temporada + "\n"+
				" Episodio = " + numeroEp + "\n"+
				" titulo = " + titulo + "\n" +
				" avaliação = " + avaliacao +"\n"+
				" data de Lancamento = " + dataLancamento +"\n";
	}
}
