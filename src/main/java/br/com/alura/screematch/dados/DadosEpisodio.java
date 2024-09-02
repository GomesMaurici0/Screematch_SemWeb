package br.com.alura.screematch.dados;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosEpisodio {

	@JsonAlias("Title")
	private String titulo;

	@JsonAlias("Episode")
	private Integer nEpisodio;

	@JsonAlias("imdbRating")
	private String avalicao;

	@JsonAlias("Released")
	private String dataLancamento;

	public String getDataLancamento() {
		return dataLancamento;
	}

	public String getAvalicao() {
		return avalicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getnEpisodio() {
		return nEpisodio;
	}
	public String toString(){
		return "Episodio: "+ getnEpisodio()+"\n"+
				"Titulo: "+ getTitulo()+ "\n";

	}
}
