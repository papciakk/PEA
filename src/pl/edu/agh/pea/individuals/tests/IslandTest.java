package pl.edu.agh.pea.individuals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class IslandTest {

    private Island population = new Island();


    @Test(expected = IllegalArgumentException.class)
    public void testSetPopulation(){
        List<Individual> list = null;
        population.setPopulation(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddIndividual(){
        Individual individual = null;
        population.addIndividual(individual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testImmigrate(){
        List<Individual> list = null;
        population.immigrate(list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmigrate(){

        Individual individual = new Individual(10);
        Individual individual2 = new Individual(10);
        Individual individual3 = new Individual(10);
        List<Individual> list = new ArrayList<Individual>();
        list.add(individual);
        list.add(individual2);
        list.add(individual3);
        System.out.println(list.size());

        population.setPopulation(list);
        population.emigrate(4);

    }

}
