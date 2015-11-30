package pl.edu.agh.pea.Operators;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;

public interface ICrossover extends IOperator{
	public Individual getResults();
	void setInput(Individual input1, Individual input2, ProblemParameters problemParameters);
}
