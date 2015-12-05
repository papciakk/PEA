package pl.edu.agh.pea.Operators.implementation;

import java.util.List;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator;

public class Mutation implements IOperator {

	private List<Individual> population;
	
	public void execute() {
		for(Individual individual : population) {
			if(Math.random() <= ProblemParameters.mutationCoefficient)
				this.mutateIndividual(individual);
		}
	}
	
	public void setInputPopulation(List<Individual> population) {
		this.population = population;		
	}
	
	private void mutateIndividual(Individual individual) {
		double newGene;
				
		for(int j = 0; j < ProblemParameters.dimensions; j++) {
			newGene = individual.getGen(j) + Math.random() * 0.2 - 0.1;
			individual.setGen(j, newGene);
		}
	}
}
