package br.com.caelum.vraptor.envie;

import java.util.HashMap;
import java.util.Map;

public class Envie {
	
	private final Map<String, Environment> envs = new HashMap<String, Environment>();
	private Environment current = get("production");

	public Environment getCurrent() {
		return current;
	}

	public Environment get(String name) {
		if(!envs.containsKey(name)) {
			register(name, new SimpleEnvironment());
		}
		return envs.get(name);
	}

	public void use(String name) {
		current = get(name);
	}

	public Derivation derive(String name) {
		return new Derivation(this, name);
	}

	public void register(String name, Environment env) {
		envs.put(name, env);
	}

}
