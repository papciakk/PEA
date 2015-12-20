package pl.edu.agh.pea.core.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import pl.edu.agh.pea.core.*;
import pl.edu.agh.pea.individuals.Individual;

public class CoreTest {
	IParametersImporter ipm = new ParametersFromFile("some_file_name");

	@Test
	public void testCore() {
		List<Individual> individuals = new LinkedList<Individual>();
		for(int i = 0; i < 20; ++i)
		{
			Individual iv = Mockito.mock(Individual.class);
			Mockito.when(iv.getFitness()).thenReturn(Double.valueOf(i));
			individuals.add(iv);
		}
		
		Core core = new Core(ipm, individuals, null);
		core.solve();
		
		assertEquals("Wrong best individual", core.getBestIndividual(), individuals.get(0));
		assertEquals("Wrong population", core.getPopulation(), individuals);
	}

}
