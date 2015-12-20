package pl.edu.agh.pea.operators.tests;

import org.junit.Test;
import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.implementation.Evaluation;
import pl.edu.agh.pea.operators.implementation.IndividualComparator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class IndividualComparatorTest {

    @Test
    public void test() {
        List<Individual> testPopulation = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            testPopulation.add(new Individual(ProblemParameters.getDimensions()));
        }

        Evaluation evaluation = new Evaluation();
        evaluation.setInputPopulation(testPopulation);
        evaluation.execute();

        IndividualComparator comparator = new IndividualComparator();

        int result = comparator.compare(testPopulation.get(0), testPopulation.get(1));
        int check = Double.compare(testPopulation.get(0).getFitness(), testPopulation.get(1).getFitness());

        assertTrue("Comparator Test", check == result);

    }
}
