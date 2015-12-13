package pl.edu.agh.pea.Operators.tests;

import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import pl.edu.agh.pea.Operators.implementation.*;


import java.util.Random;
import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator; 

public class SelectionTest{

	@Test
	public void test(){
		int dimensions = 10; int individuals = 4;
		List<Individual> list1 = new ArrayList<Individual>();
		for(int i = 0; i < individuals; i++) list1.add(new Individual(dimensions));

		Evaluation evaluation = new Evaluation();
		evaluation.setInputPopulation(list1);
		evaluation.execute();
		
		Selection selection = new Selection();
		selection.setInputPopulation(list1);
		selection.execute();
		assertTrue("Selection Test", list1.size() <= individuals );
	}
}
