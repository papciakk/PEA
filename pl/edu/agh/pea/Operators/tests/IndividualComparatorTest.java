package pl.edu.agh.pea.Operators.tests;

import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import pl.edu.agh.pea.Operators.implementation.*;

import java.util.Comparator;
import pl.edu.agh.pea.Individuals.Individual;
 


public class IndividualComparatorTest{

	@Test
	public void test(){
		int dimensions = 10;
		List<Individual> list1 = new ArrayList<Individual>();
		for(int i = 0; i < 2; i++) list1.add(new Individual(dimensions));
		Evaluation evaluation = new Evaluation();
		evaluation.setInputPopulation(list1);
		evaluation.execute();
		
		
		
		IndividualComparator comparator = new IndividualComparator();
		int result = comparator.compare(list1.get(0), list1.get(1));
		int check = Double.compare(list1.get(0).getFitness(), list1.get(1).getFitness());
		assertTrue("Comparator Test", check == result);
		
	}
}


