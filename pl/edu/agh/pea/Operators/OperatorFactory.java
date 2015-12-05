package pl.edu.agh.pea.Operators;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.pea.Operators.implementation.Crossover;
import pl.edu.agh.pea.Operators.implementation.Evaluation;
import pl.edu.agh.pea.Operators.implementation.Mutation;
import pl.edu.agh.pea.Operators.implementation.Selection;

public class OperatorFactory {
	private static Crossover crossoverOperator = null;
	private static Evaluation evaluationOperator = null;
	private static Mutation mutationOperator = null;
	private static Selection selectionOperator = null;
	
	/**
	 * @return
	 * Returns crossover operator instance
	 */
	public static Crossover getCrossoverOperatorInstance() {
		if(crossoverOperator == null) crossoverOperator = new Crossover();
		return crossoverOperator;
	}
	
	/**
	 * @return
	 * Returns evaluation operator instance
	 */
	public static Evaluation getEvaluationOperatorInstance() {
		if(evaluationOperator == null) evaluationOperator = new Evaluation();
		return evaluationOperator;
	}
	
	/**
	 * @return
	 * Returns mutation operator instance
	 */
	public static Mutation getMutationOperatorInstance() {
		if(mutationOperator == null) mutationOperator = new Mutation();
		return mutationOperator;
	}
	
	/**
	 * @return
	 * Returns selection operator instance
	 */
	public static Selection getSelectionOperatorInstance() {
		if(selectionOperator == null) selectionOperator = new Selection();
		return selectionOperator;
	}
	
	/**
	 * @param operatorNames
	 * @return
	 * Returns list of operators in order given by list of strings
	 */
	public static List<IOperator> getOperatorList (List<String> operatorNames) {
		Method getInstance = null;
		String methodName;
		List<IOperator> operators = new ArrayList<IOperator>();		
		
		for (String opName : operatorNames) {
		
			methodName = "get" + opName + "OperatorInstance";
			
			try {
				getInstance = OperatorFactory.class.getMethod(methodName);
			}catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
			try {
				operators.add((IOperator) getInstance.invoke(OperatorFactory.class));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		return operators;
	}
}