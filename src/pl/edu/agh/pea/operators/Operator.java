package pl.edu.agh.pea.operators;

import java.util.List;

import pl.edu.agh.pea.individuals.Individual;

public abstract class Operator {

    protected List<Individual> population = null;

    public void setInputPopulation(List<Individual> population) {
        if (population == null) {
            throw new NullPointerException("Population has not been initialized");
        }
        else if (population.isEmpty()) {
            throw new IllegalArgumentException("Population is empty");
        }
        else this.population = population;
    }

    public void execute() {
        if (population == null) {
            throw new NullPointerException("Input population has not been set up");
        } else {
            doOperation();
        }
    }

    protected abstract void doOperation();
}
