package pl.edu.agh.pea.operators.tests;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.implementation.Mutation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MutationTest {

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

        List<double[]> unmutated = new ArrayList<>();

        for(Individual ind : testPopulation) {
            unmutated.add(ind.getGenotype().clone());
        }

        Mutation mutation = new Mutation();
        mutation.setInputPopulation(testPopulation);
        mutation.execute();

        // check if genotype after mutation is different than before
        for (int i = 0; i < testPopulation.size(); i++) {
            boolean mutationResult = areGenotypesDifferent(
                    testPopulation.get(i).getGenotype(),
                    unmutated.get(i));
            assertTrue("Mutation Test", mutationResult);
        }
    }

    private static boolean areGenotypesDifferent(double[] g1, double[] g2) {
        for (int i = 0; i < g1.length; i++) {
            if(Double.compare(g1[i], g2[i]) == 0) {
                return false;
            }
        }
        return true;
    }
}
