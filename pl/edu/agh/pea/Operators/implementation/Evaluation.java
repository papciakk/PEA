package pl.edu.agh.pea.Operators.implementation;

import java.util.List;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator;

interface Fnc<T, R> {
	R apply(T x);
} 

public class Evaluation implements IOperator {

	private List<Individual> population;

	Fnc<Individual, Double> lt_1 = (x) -> {
		double fitness;
		double gene;

		fitness = ProblemParameters.ACoefficient * ProblemParameters.dimensions;
		for(int i = 0; i < ProblemParameters.dimensions; i++) {
			gene = x.getGen(i);
			fitness += gene*gene - ProblemParameters.ACoefficient*Math.cos(2.0*Math.PI*gene);
		}
		return fitness;
	};

	public void execute() {
		if(population == null) {
			System.out.println("Nie ustawiono populacji wejściowej");
			return;
		}
		
		for(Individual individual : population) {
			this.evaluateIndividual(lt_1, individual);
		}
	}

	public void setInputPopulation(List<Individual> population) {
		if (population != null || population.size() == 0) {
			System.out.println("Populacja nie zostala poprawnie zainicjowana.");
			return;
		}
		this.population = population;
	}
	
	private void evaluateIndividual(Fnc<Individual, Double> function, Individual individual) {
		double fitness;
		double gene;
		
		fitness = function.apply(individual);

		individual.setFitness(fitness);
	}
}
