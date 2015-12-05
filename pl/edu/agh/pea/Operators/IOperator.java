package pl.edu.agh.pea.Operators;

import java.util.List;
import pl.edu.agh.pea.Individuals.Individual;

public interface IOperator {
	
	/**
	 * @param population
	 * Sets the reference to list of individuals.
	 */
	public void setInputPopulation(List<Individual> population);
	
	/**
	 * Executes the operator on the population.
	 * Original population is updated.
	 */
	public void execute();
}
