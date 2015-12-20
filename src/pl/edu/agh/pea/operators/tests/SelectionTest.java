package pl.edu.agh.pea.operators.tests;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.implementation.Evaluation;
import pl.edu.agh.pea.operators.implementation.Selection;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SelectionTest {

    @Before
    public void init() {
        Tests.initProblemParameters();
    }

    @Test
    public void test() {
        List<Individual> testPopulation = new ArrayList<>();

        for (int i = 0; i < ProblemParameters.getPopulation() * 5; i++) {
            testPopulation.add(new Individual(ProblemParameters.getDimensions()));
        }

        Evaluation evaluation = new Evaluation();
        evaluation.setInputPopulation(testPopulation);
        evaluation.execute();

        Selection selection = new Selection();
        selection.setInputPopulation(testPopulation);
        selection.execute();

        // test number of selected individuals
        assertTrue("Selection Test - size", testPopulation.size() == ProblemParameters.getPopulation());

        // test if population is sorted
        boolean sorted = true;
        for (int i = 0; i < testPopulation.size() - 1; i++) {
            if (testPopulation.get(i).getFitness() >= testPopulation.get(i + 1).getFitness()) {
                sorted = false;
                break;
            }
        }

        assertTrue("Selection Test - is sorted", sorted);
    }
}
