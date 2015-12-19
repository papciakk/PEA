package pl.edu.agh.pea.operators.tests;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.implementation.Crossover;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CrossoverTest {

    @Before
    public void init() {
        Tests.initProblemParameters();
    }

    @Test
    public void test() {
        List<Individual> testPopulation = new ArrayList<>();
        for (int i = 0; i < ProblemParameters.population; i++) {
            testPopulation.add(new Individual(ProblemParameters.dimensions));
        }

        Crossover crossover = new Crossover();
        crossover.setInputPopulation(testPopulation);
        crossover.execute();

        int childrenCount = testPopulation.size() - ProblemParameters.population;

        //crossover coefficient is 1.0, so there should be <population size>^2 children
        assertTrue("Crossover Test",
                childrenCount == ProblemParameters.population*ProblemParameters.population);
    }
}
