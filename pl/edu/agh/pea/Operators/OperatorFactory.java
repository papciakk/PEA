package pl.edu.agh.pea.Operators;

import pl.edu.agh.pea.Operators.implementation.Crossover;
import pl.edu.agh.pea.Operators.implementation.Evaluation;
import pl.edu.agh.pea.Operators.implementation.Mutation;
import pl.edu.agh.pea.Operators.implementation.Selection;

public class OperatorFactory {
	private static Crossover crossoverOperator;
	private static Evaluation evaluationOperator;
	private static Mutation mutationOperator;
	private static Selection selectionOperator;
	
	public OperatorFactory() {
		OperatorFactory.crossoverOperator = new Crossover();
		OperatorFactory.evaluationOperator = new Evaluation();
		OperatorFactory.mutationOperator = new Mutation();
		OperatorFactory.selectionOperator = new Selection();
	}
	
	public Crossover getCrossoverOperator() {
		return crossoverOperator;
	}
	
	public Evaluation getEvaluationOperator() {
		return evaluationOperator;
	}
	
	public Mutation getMutationOperator() {
		return mutationOperator;
	}
	
	public Selection getSelectionOperator() {
		return selectionOperator;
	}
}