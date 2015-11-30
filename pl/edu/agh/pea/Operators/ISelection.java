package pl.edu.agh.pea.Operators;

import java.util.List;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;

public interface ISelection extends IOperator {
	public List<Individual> getResults();
	void setInput(List<Individual> input, ProblemParameters problemParameters);
}
