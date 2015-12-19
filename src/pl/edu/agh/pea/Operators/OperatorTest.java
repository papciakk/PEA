package pl.edu.agh.pea.Operators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import pl.edu.agh.pea.Operators.tests.*;


public class OperatorTest{
	
	public static void main (String argv[]){
		Result result = JUnitCore.runClasses(CrossoverTest.class);
		for (Failure failure : result.getFailures()) System.out.println(failure.toString());
		System.out.println("1. Crossover Test: " + result.wasSuccessful());

		result = JUnitCore.runClasses(MutationTest.class);
		for (Failure failure : result.getFailures()) System.out.println(failure.toString());
		System.out.println("2. Mutation Test: " + result.wasSuccessful());

		result = JUnitCore.runClasses(EvaluationTest.class);
		for (Failure failure : result.getFailures()) System.out.println(failure.toString());
		System.out.println("3. Evaluation Test: " + result.wasSuccessful());
		
		result = JUnitCore.runClasses(IndividualComparatorTest.class);
		for (Failure failure : result.getFailures()) System.out.println(failure.toString());
		System.out.println("4. Individual Comparator Test: " + result.wasSuccessful());

		result = JUnitCore.runClasses(SelectionTest.class);
		for (Failure failure : result.getFailures()) System.out.println(failure.toString());
		System.out.println("5. Selection Test: " + result.wasSuccessful());
		
	}
	
}

