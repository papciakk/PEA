package pl.edu.agh.pea.Operators.implementation;

import java.util.List;
import java.util.PriorityQueue;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.ISelection;

public class Selection implements ISelection {

	private PriorityQueue<Individual> heap;
	private List<Individual> data;
	private ProblemParameters problemParameters;
	private IndividualComparator comparator;
	
	public Selection() {
		comparator = new IndividualComparator();
	}
	
	public void execute() {
		heap = new PriorityQueue<Individual>(comparator);
		
		heap.addAll(data);
		
		this.data.clear();
	    for(int i = 0; i < problemParameters.population; i++) {
	    	data.add(heap.poll());
	    }
	}

	public void setInput(List<Individual> input, ProblemParameters problemParameters) {
		this.data = input;
		this.problemParameters = problemParameters;
	}

	public List<Individual> getResults() {
		return data;
	}
}