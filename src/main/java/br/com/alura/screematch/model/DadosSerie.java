package br.com.alura.screematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosSerie {

	@JsonAlias("Title")
	private String titulo;

	@JsonAlias("Year")
	private String year;

	@JsonAlias("Genre")
	private String genero;

	@JsonAlias("totalSeasons")
	private Integer totalTemporadas;

	public String getTitulo() {
		return titulo;
	}

	public String getYear() {
		return year;
	}

	public String getGenero() {
		return genero;
	}

	public Integer getTotalTemporadas() {
		return totalTemporadas;
	}
	public String toString(){
		return
				"Titulo: "+ titulo+ "\n"+
				"Ano: "+ year+ "\n"+
				"Genero:  "+ genero+ "\n"+
				"Total de Temporadas: "+totalTemporadas;
	}
}
