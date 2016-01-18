package pl.edu.agh.pea.operators.tests;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.individuals.Island;
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
        for (int i = 0; i < ProblemParameters.getPopulation(); i++) {
            testPopulation.add(new Individual(ProblemParameters.getDimensions()));
        }

        Island island = new Island();
        island.setPopulation(testPopulation);

        Crossover crossover = new Crossover();
        crossover.setInputPopulation(island);
        crossover.execute();

        int childrenCount = testPopulation.size() - ProblemParameters.getPopulation();

        //crossover coefficient is 1.0, so there should be <population size>^2 children
        int popSize = ProblemParameters.getPopulation();
        assertTrue("Crossover Test",
                childrenCount == popSize*popSize);
    }
}
