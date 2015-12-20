package pl.edu.agh.pea.core;
import com.google.inject.AbstractModule;

public class CoreModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(IParametersImporter.class).to(ParametersFromFile.class);
	}
}
