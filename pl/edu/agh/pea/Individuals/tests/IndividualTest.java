package pl.edu.agh.pea.Individuals;

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

    @Test(expected = IllegalArgumentException.class)
    public void testIndividualNull(){
        double [] newGenotype = null;
        Individual newIndividual = new Individual(newGenotype);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndividualIllegalLength(){
        double [] newGenotype = new double[]{};
        Individual newIndividual = new Individual(newGenotype);
    }

    @Test
    public void testSetFitness() throws Exception {
        individual.setFitness(10.15);
        assertEquals(10.15, individual.getFitness(), 0.01);

        individual2.setFitness(6.7);
        assertNotEquals(4.5, individual2.getFitness(), 0.01);
    }

    @Test
    public void testSetGenotype() throws Exception{
        individual.setGenotype(new double[]{2.5, 3.4, 5.1});
        assertArrayEquals(new double[]{2.5, 3.4, 5.1}, individual.getGenotype(), 0.01);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetGenotypeIllegalArgument() throws Exception {
        individual2.setGenotype(new double[] {5.1, 5.6, 2.1});
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetGenotypeIllegalLength() throws Exception {
        individual.setGenotype(new double[] {5.1, 3.9});
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetGenotypeNull() throws Exception {
        double [] newGenotype = null;
        individual.setGenotype(newGenotype);
    }


    @Test
    public void testSetGen() throws Exception {
        individual.setGen(2, 3.4);
        assertEquals(3.4, individual.getGen(2), 0.01);
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetGenIndexOutOfBound(){
        individual.setGen(10, 4.5);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetGenIllegalArgument(){
        individual.setGen(1, 12.5);
    }


    @Test(expected = Exception.class)
    public void testGetGen() throws Exception {
        individual.getGen(10);
    }
}
