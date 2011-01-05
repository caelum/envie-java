package br.com.caelum.vraptor.envie;

import java.util.ArrayList;
import java.util.List;

public class SimpleEnvironment implements Environment {

	private final List<Class> features = new ArrayList<Class>();
	private final Environment parent;

	public SimpleEnvironment(Environment parent) {
		this.parent = parent;
	}

	public SimpleEnvironment() {
		this(new EmptyEnvironment());
	}

	public <T> Environment with(Class<T> feature) {
		features.add(feature);
		return this;
	}

	@Override
	public <T> boolean hasFeature(Class<T> feature) {
		return features.contains(feature) || parent.hasFeature(feature);
	}

}
