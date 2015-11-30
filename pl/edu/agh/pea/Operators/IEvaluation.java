package pl.edu.agh.pea.Operators;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;

public interface IEvaluation extends IOperator {
	public void setInput(Individual input, ProblemParameters problemParameters);
	public double getResults();
}
