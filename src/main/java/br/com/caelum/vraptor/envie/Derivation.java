package br.com.caelum.vraptor.envie;

public class Derivation {

	private final Envie envie;
	private final String name;

	public Derivation(Envie envie, String name) {
		this.envie = envie;
		this.name = name;
	}

	public Environment from(Environment parent) {
		SimpleEnvironment env = new SimpleEnvironment(parent);
		envie.register(name, env);
		return env;
	}

}
