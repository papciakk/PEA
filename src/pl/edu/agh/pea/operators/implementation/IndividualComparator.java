package pl.edu.agh.pea.operators.implementation;

import java.util.Comparator;

import pl.edu.agh.pea.individuals.Individual;

public class IndividualComparator implements Comparator<Individual> {

    public int compare(Individual i1, Individual i2) {
        return Double.compare(i1.getFitness(), i2.getFitness());
    }
}
