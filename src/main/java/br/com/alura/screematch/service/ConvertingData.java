package br.com.alura.screematch.service;

public interface ConvertingData {

	<T>T Mdados(String json, Class<T> classe);

}
