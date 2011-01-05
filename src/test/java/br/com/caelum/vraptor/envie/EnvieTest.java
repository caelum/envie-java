package br.com.caelum.vraptor.envie;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EnvieTest {
	
	@Test
	public void shouldUseProductionByDefault() {
		Envie envie = new Envie();
		assertThat(envie.getCurrent(), is(equalTo(envie.get("production"))));
	}
	
	@Test
	public void shouldChangeTheCurrentEnvironment() {
		Envie envie = new Envie();
		envie.use("test");
		assertThat(envie.getCurrent(), is(equalTo(envie.get("test"))));
	}
	
	@Test
	public void shouldRegisterChildrenEnvironments() {
		Envie envie = new Envie();
		Environment test = envie.derive("test").from(envie.get("production"));
		assertThat(test, is(equalTo(envie.get("test"))));
	}

}
