package pl.edu.agh.pea.operators.implementation;

import java.util.Random;

import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.Operator;

public class Crossover extends Operator {

    private Random rand;

    public Crossover() {
        rand = new Random();
        population = null;
    }

    protected void doOperation() {

        double[] newGenotype;
        double[] genotype1;
        double[] genotype2;

        for (int i = 0; i < ProblemParameters.population; i++)
            for (int j = 0; j < ProblemParameters.population; j++) {
                if (rand.nextDouble() <= ProblemParameters.crossCoefficient) {
                    genotype1 = population.get(i).getGenotype();
                    genotype2 = population.get(j).getGenotype();

                    newGenotype = crossoverIndividuals(genotype1, genotype2);
                    population.add(new Individual(newGenotype));
                }
            }
    }

    private double[] crossoverIndividuals(double[] genotype1, double[] genotype2) {

        int genotypeLength = genotype1.length;

        int gene1, gene2;
        double[] newGenotype = new double[genotypeLength];

        for (int k = 0; k < genotypeLength; k++) {
            gene1 = rand.nextInt(genotypeLength - 1);
            gene2 = rand.nextInt(genotypeLength - 1);

            newGenotype[k] = (genotype1[gene1] + genotype2[gene2]) / 2;
        }
        return newGenotype;
    }

}
