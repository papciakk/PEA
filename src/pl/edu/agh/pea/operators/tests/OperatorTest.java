package pl.edu.agh.pea.operators.tests;

import org.junit.Test;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.implementation.Evaluation;

import java.util.ArrayList;
import java.util.List;

public class OperatorTest {

    @Test (expected = IllegalArgumentException.class)
    public void testSetEmptyPopulation() {
        List<Individual> testPopulation = new ArrayList<>();
        Evaluation e = new Evaluation();
        e.setInputPopulation(testPopulation);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNullPopulation() {
        List<Individual> testPopulation = null;
        Evaluation e = new Evaluation();
        e.setInputPopulation(testPopulation);
    }

    @Test (expected = NullPointerException.class)
    public void testExecute() {
        Evaluation e = new Evaluation();
        e.execute();
    }
}