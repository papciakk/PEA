package pl.edu.agh.pea.operators.implementation;

import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.Operator;

public class Mutation extends Operator {

    protected void doOperation() {
        for (Individual individual : population) {
            if (Math.random() <= ProblemParameters.getMutationCoefficient()) {
                this.mutateIndividual(individual);
            }
        }
    }

    private void mutateIndividual(Individual individual) {
        Double newGene;
        double change = 0.0;

        for (int j = 0; j < ProblemParameters.getDimensions(); j++) {
            while(Double.compare(change, 0.0) == 0) {
                change = Math.random() * 0.2 - 0.1;
            }

            newGene = individual.getGen(j) + change;

            if (newGene.compareTo(5.12) > 0) {
                newGene = 5.12;
            } else if (newGene.compareTo(-5.12) < 0) {
                newGene = -5.12;
            }

            individual.setGen(j, newGene);
        }
    }
}
