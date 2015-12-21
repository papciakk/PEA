package pl.edu.agh.pea.core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.edu.agh.pea.core.ParametersFromFile;
import pl.edu.agh.pea.core.ProblemParameters;

public class ParametersFromFileTest {

	@Test
	public void test() {
		double coeffSum = 0.5 + 0.05;
		
		if(coeffSum == 0.0)
		{
			throw new ArithmeticException("Division by zero");
		}
		
		ParametersFromFile pff = new ParametersFromFile("config.txt");
		assertEquals("Wrong file name", pff.getFileName(), "config.txt");
		
		assertEquals("Couldn't load the file", pff.importParameters(), true);
		
		assertEquals("Wrong value (A Coeff)", ProblemParameters.getACoefficient() == 10.0, true);
		
		assertEquals("Wrong value (Cross Coefficient)", ProblemParameters.getCrossCoefficient() == (0.5 / coeffSum), true);
		
		assertEquals("Wrong value (Mutation Coefficient)", ProblemParameters.getMutationCoefficient() == (0.05 / coeffSum), true);
		
		assertEquals("Wrong value (Generations)", ProblemParameters.getGenerations(), 20);
		
		assertEquals("Wrong value (Population)", ProblemParameters.getPopulation(), 50);
		
		assertEquals("Wrong value (Dimensions)", ProblemParameters.getDimensions(), 20);
	}

}
