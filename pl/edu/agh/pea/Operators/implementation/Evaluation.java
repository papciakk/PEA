package pl.edu.agh.pea.Operators.implementation;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IEvaluation;

public class Evaluation implements IEvaluation {

	private ProblemParameters problemParameters;
	private Individual individual;
	private double fitness;

	public void execute() {
		double gene;
		fitness = problemParameters.ACoefficient * problemParameters.dimensions;

		for(int i = 0; i < problemParameters.dimensions; i++) {
			gene = individual.getGen(i);
			fitness += gene * gene - problemParameters.ACoefficient * Math.cos(2.0*Math.PI * gene);
		}
	}

	public void setInput(Individual input, ProblemParameters problemParameters) {
		this.individual = input;
		this.problemParameters = problemParameters;
	}

	public double getResults() {
		return fitness;
	}
}
