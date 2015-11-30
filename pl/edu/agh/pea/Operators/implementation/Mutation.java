package pl.edu.agh.pea.Operators.implementation;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IMutation;

public class Mutation implements IMutation {

	private Individual individual;
	ProblemParameters problemParameters;
	
	public void execute() {
		double newGene;
		
		for(int j = 0; j < problemParameters.dimensions; j++) {
			newGene = individual.getGen(j) + Math.random() * 0.2 - 0.1;
			individual.setGen(j, newGene);
		}
	}

	public void setInput(Individual input, ProblemParameters problemParameters) {
		this.individual = input;
		this.problemParameters = problemParameters;
	}

	public Individual getResults() {
		return individual;
	}
}
