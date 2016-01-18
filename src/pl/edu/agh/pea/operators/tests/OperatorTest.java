package pl.edu.agh.pea.operators.tests;

import org.junit.Test;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.individuals.Island;
import pl.edu.agh.pea.operators.implementation.Evaluation;

import java.util.ArrayList;
import java.util.List;

public class OperatorTest {

    @Test (expected = IllegalArgumentException.class)
    public void testSetEmptyPopulation() {
        List<Individual> testPopulation = new ArrayList<>();

        Island island = new Island();
        island.setPopulation(testPopulation);

        Evaluation e = new Evaluation();
        e.setInputPopulation(island);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNullPopulation() {
        List<Individual> testPopulation = null;

        Island island = new Island();
        island.setPopulation(testPopulation);

        Evaluation e = new Evaluation();
        e.setInputPopulation(island);
    }

    @Test (expected = NullPointerException.class)
    public void testExecute() {
        Evaluation e = new Evaluation();
        e.execute();
    }
}