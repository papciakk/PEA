package pl.edu.agh.pea.Operators.implementation;

import java.util.List;
import java.util.PriorityQueue;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator;

public class Selection implements IOperator {

	private PriorityQueue<Individual> heap;
	private IndividualComparator comparator;
	
	private List<Individual> population;
	
	public Selection() {
		comparator = new IndividualComparator();
	}
	
	public void execute() {
		if(population == null) {
			System.out.println("Nie ustawiono populacji wejściowej");
			return;
		}
			
		heap = new PriorityQueue<Individual>(comparator);
		
		heap.addAll(population);
		
		this.population.clear();
	    for(int i = 0; i < ProblemParameters.population; i++) {
	    	population.add(heap.poll());
	    }
	}

	public void setInputPopulation(List<Individual> population) {
		if (population != null || population.size() == 0) {
			System.out.println("Populacja nie zostala poprawnie zainicjowana.");
			return;
		}
		this.population = population;
	}
}