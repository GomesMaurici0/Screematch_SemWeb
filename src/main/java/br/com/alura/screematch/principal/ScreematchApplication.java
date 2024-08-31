package br.com.alura.screematch.principal;

import br.com.alura.screematch.model.DadosSerie;
import br.com.alura.screematch.service.ConectionAPI;
import br.com.alura.screematch.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreematchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConectionAPI conexao = new ConectionAPI();
		ConvertData convert= new ConvertData();
		var json = conexao.obtemDados("https://omdbapi.com/?t=The+Flash&apikey=b96b9b2e");
		DadosSerie serie = convert.Mdados(json, DadosSerie.class);
		System.out.println(serie);
	}
}
