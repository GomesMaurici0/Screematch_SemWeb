package br.com.alura.screematch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectionAPI {
	public String obtemDados(String endereco){
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder(URI.create(endereco)).build();
		HttpResponse<String> response ;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		String json = response.body();
		return json;
	}
}
