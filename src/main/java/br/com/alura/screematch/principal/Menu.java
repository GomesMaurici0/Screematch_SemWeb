package br.com.alura.screematch.principal;

import br.com.alura.screematch.dados.DadosEpisodio;
import br.com.alura.screematch.dados.DadosSerie;
import br.com.alura.screematch.dados.DadosTemporada;
import br.com.alura.screematch.modelo.Episodio;
import br.com.alura.screematch.service.ConectionAPI;
import br.com.alura.screematch.service.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

	private Scanner sc = new Scanner(System.in);
	private ConectionAPI conectar = new ConectionAPI();

	private ConvertData convert = new ConvertData();

	private final String ENDERECO = "https://omdbapi.com/?t=" ;
	private final String APIKEY = "&apikey=b96b9b2e";

	public void exibirMenu(){

		List<DadosTemporada> temporadas = new ArrayList<>();
		System.out.print("Digite um nome de uma Série: ");
		String nomeSerie = sc.nextLine().replace(" ","+");

		var json=  conectar.obtemDados(ENDERECO+nomeSerie+APIKEY);
		DadosSerie convertingSerie = convert.Mdados(json, DadosSerie.class);
		DadosEpisodio dadosEpisodio = convert.Mdados(json,DadosEpisodio.class);

		System.out.println(convertingSerie);
		for (int i = 1; i <= convertingSerie.getTotalTemporadas(); i++){
			json = conectar.obtemDados(ENDERECO+nomeSerie+"&Season="+i+"&"+APIKEY);
			var convertEpisodio = convert.Mdados(json,DadosTemporada.class);
			temporadas.add(convertEpisodio);
		}

		List<Episodio> episodios = temporadas.stream()
				.flatMap(t -> t.getEpisodios().stream().map(e -> new Episodio(t.getNumeroTemporada() , e)))
				.collect(Collectors.toList());
		episodios.forEach(System.out::println);

	}
}
