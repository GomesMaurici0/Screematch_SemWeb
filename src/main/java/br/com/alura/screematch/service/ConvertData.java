package br.com.alura.screematch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements ConvertingData {
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T Mdados(String json, Class<T> classe) {
		try {
			return mapper.readValue(json,classe);
		}
		catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
