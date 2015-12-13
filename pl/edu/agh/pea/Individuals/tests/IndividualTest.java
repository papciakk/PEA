package pl.edu.agh.pea.individuals;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IndividualTest {

    private Individual individual;
    private Individual individual2;

    @Before
    public void setup() {
        individual = new Individual(new double[]{ 1.0, 2.0, 3.0 });
        individual2 = new Individual(4);
    }

    @Test
    public void testSetFitness() throws Exception {
        individual.setFitness(10.15);
        assertEquals(10.15, individual.getFitness(), 0.01);

        individual2.setFitness(6.7);
        assertNotEquals(4.5, individual2.getFitness(), 0.01);
    }

    @Test
    public void testSetGenotype() throws Exception {
        individual.setGenotype(new double[]{2.5, 3.4, 5.6});
        assertArrayEquals(new double[]{2.5, 3.4, 5.6}, individual.getGenotype(), 0.01);
    }

    @Test(expected = Exception.class)
    public void testSetGet() throws Exception {
        individual.setGen(2, 3.4);
        assertEquals(3.4, individual.getGen(2), 0.01);

        individual2.setGen(10, 4.5);
    }

    @Test(expected = Exception.class)
    public void testGetGen() throws Exception {;
        individual.getGen(10);
    }
}
