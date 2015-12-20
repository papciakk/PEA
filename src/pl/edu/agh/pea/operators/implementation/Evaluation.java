package pl.edu.agh.pea.operators.implementation;

import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.Operator;

interface IFnc<T, R> {
    R apply(T x);
}

public class Evaluation extends Operator {

    private final IFnc<Individual, Double> evaluate = x -> {
        double fitness;
        double gene;

        fitness = ProblemParameters.ACoefficient * ProblemParameters.dimensions;
        for (int i = 0; i < ProblemParameters.dimensions; i++) {
            gene = x.getGen(i);
            fitness += gene * gene - ProblemParameters.ACoefficient * Math.cos(2.0 * Math.PI * gene);
        }
        return fitness;
    };

    protected void doOperation() {
        for (Individual individual : population) {
            this.evaluateIndividual(evaluate, individual);
        }
    }

    private void evaluateIndividual(IFnc<Individual, Double> function, Individual individual) {
        double fitness;

        fitness = function.apply(individual);
        individual.setFitness(fitness);
    }
}
