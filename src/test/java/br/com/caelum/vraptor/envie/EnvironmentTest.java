package br.com.caelum.vraptor.envie;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EnvironmentTest {
	
	public interface OAuth {
	}
	public interface OpenId {
	}
	
	@Test
	public void shouldSupportOnlyTheFeaturesThatHaveBeenAdded() {
		Environment production = new SimpleEnvironment().with(OAuth.class);
		assertThat(production.hasFeature(OAuth.class), is(true));
		assertThat(production.hasFeature(OpenId.class), is(false));
	}

	@Test
	public void shouldSupportFeaturesAddedToItsParent() {
		Environment production = new SimpleEnvironment().with(OAuth.class);
		Environment test = new SimpleEnvironment(production).with(OpenId.class);
		assertThat(test.hasFeature(OAuth.class), is(true));
	}

	@Test
	public void shouldNoSupportFeaturesFromItsChild() {
		Environment production = new SimpleEnvironment().with(OAuth.class);
		Environment test = new SimpleEnvironment(production).with(OpenId.class);
		assertThat(production.hasFeature(OpenId.class), is(false));
	}

}
