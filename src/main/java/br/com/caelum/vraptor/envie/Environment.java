package br.com.caelum.vraptor.envie;

public interface Environment {

	<T> boolean hasFeature(Class<T> type);

}
