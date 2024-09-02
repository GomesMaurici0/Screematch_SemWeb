package br.com.alura.screematch.dados;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosTemporada {

	@JsonAlias("Season")
	private Integer numeroTemporada;

	@JsonAlias("Episodes")
	private List<DadosEpisodio> episodios = new ArrayList<>();

	public List<DadosEpisodio> getEpisodios() {
		return episodios;
	}

	public Integer getNumeroTemporada() {
		return numeroTemporada;
	}

	@Override
	public String toString() {
		return
				"\n"+"Temporada= " + numeroTemporada +"\n"
				+"Episodios = "+ episodios.size() + "\n" + episodios;
	}
}
