package br.com.caelum.vraptor.envie;

public class EmptyEnvironment implements Environment {

	public <T> boolean hasFeature(Class<T> type) {
		return false;
	}

}
