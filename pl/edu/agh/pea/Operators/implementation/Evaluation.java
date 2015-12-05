package pl.edu.agh.pea.Operators.implementation;

import java.util.List;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator;

public class Evaluation implements IOperator {

	private List<Individual> population;

	public void execute() {
		for(Individual individual : population) {
			this.evaluateIndividual(individual);
		}
	}

	public void setInputPopulation(List<Individual> population) {
		this.population = population;
	}
	
	private void evaluateIndividual(Individual individual) {
		double fitness;
		double gene;
		
		fitness = ProblemParameters.ACoefficient * ProblemParameters.dimensions;
		for(int i = 0; i < ProblemParameters.dimensions; i++) {
			gene = individual.getGen(i);
			fitness += gene*gene - ProblemParameters.ACoefficient*Math.cos(2.0*Math.PI*gene);
		}
		
		individual.setFitness(fitness);
	}
}