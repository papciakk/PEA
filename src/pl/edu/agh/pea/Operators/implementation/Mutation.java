package pl.edu.agh.pea.Operators.implementation;

import java.util.List;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator;

public class Mutation implements IOperator {

	private List<Individual> population;
	
	public void execute() {
		if(population == null) {
			System.out.println("Nie ustawiono populacji wejściowej");
			return;
		}
		
		for(Individual individual : population) {
			if(Math.random() <= ProblemParameters.mutationCoefficient)
				this.mutateIndividual(individual);
		}
	}
	
	public void setInputPopulation(List<Individual> population) {
		if (population != null || population.size() == 0) {
			System.out.println("Populacja nie zostala poprawnie zainicjowana.");
			return;
		}
		this.population = population;		
	}
	
	private void mutateIndividual(Individual individual) {
		double newGene;
				
		for(int j = 0; j < ProblemParameters.dimensions; j++) {
			newGene = individual.getGen(j) + Math.random() * 0.2 - 0.1;
			if (newGene > 5.12) newGene = 5.12;
			else if (newGene < -5.12) newGene = -5.12;
			individual.setGen(j, newGene);
		}
	}
}
