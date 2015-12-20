package pl.edu.agh.pea.operators.tests;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.implementation.Evaluation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EvaluationTest {

    @Before
    public void init() {
        Tests.initProblemParameters();
    }

    @Test
    public void test() {
        boolean notNaN;
        boolean sameResults;

        List<Individual> testPopulation = new ArrayList<>();
        for (int i = 0; i < ProblemParameters.getPopulation(); i++) {
            testPopulation.add(new Individual(ProblemParameters.getDimensions()));
        }

        Evaluation evaluation = new Evaluation();
        evaluation.setInputPopulation(testPopulation);
        evaluation.execute();

        for (int i = 0; i < ProblemParameters.getPopulation(); i++) {
            notNaN = !Double.isNaN(testPopulation.get(i).getFitness());
            sameResults = Double.compare(testPopulation.get(i).getFitness(),
                    rastrigin(testPopulation.get(i))) == 0;

            assertTrue("Evaluation Test", notNaN && sameResults);
        }
    }

    private double rastrigin(Individual ind) {
        double fitness;
        double gene;

        fitness = ProblemParameters.getACoefficient() * ProblemParameters.getDimensions();
        for (int i = 0; i < ProblemParameters.getDimensions(); i++) {
            gene = ind.getGen(i);
            fitness += gene * gene - ProblemParameters.getACoefficient() * Math.cos(2.0 * Math.PI * gene);
        }
        return fitness;
    }
}
