package pl.edu.agh.pea.Operators;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Core.ProblemParameters;

public class Operators {
	
	private Random rand;
	
	private List<Individual> population;
	private Individual bestIndividual;
	
	private ProblemParameters problemParameters;
	
	public Operators (List<Individual> population, ProblemParameters problemParameters) {
		this.rand = new Random();
		
		this.problemParameters = problemParameters;
		this.population = population;
	}
	
	public Individual nextGeneration () {
		evaluate();
		select();
		crossover();
		mutate();
		
		return bestIndividual;
	}
	
	private void evaluate() {
		for(Individual i : population) {
			i.updateFitness();
		}
	}
	
	private void select() {
	    PriorityQueue<Individual> heap = new PriorityQueue<Individual>(population.size(), new Comparator<Individual>() {
	    	public int compare(Individual i1, Individual i2) {
	    		return Double.compare(i1.getFitness(), i2.getFitness());
	    	}
	    });
	    
	    heap.addAll(population);
	    
	    try {
	    	bestIndividual = heap.peek().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	 
	    population.clear();
	    for(int i = 0; i < problemParameters.population; i++) {
	    	population.add(heap.poll());
	    }
	}
	
	private void crossover() {
		for(int j = 0; j < problemParameters.population; j++)
			for(int i = 0; i < problemParameters.population; i++)
				if(i!=j && (Math.random() <= problemParameters.crossCoefficient)) {
					Individual child = new Individual(problemParameters, false);
					for(int k = 0; k < problemParameters.dimensions; k++) {
						child.x[k] = (population.get(i).x[rand.nextInt(problemParameters.dimensions-1)] 
								+ population.get(j).x[rand.nextInt(problemParameters.dimensions-1)])/2;
					}
					population.add(child);
				}
	}
	
	private void mutate() {
		for(Individual i : population)
			if(rand.nextDouble() <= problemParameters.mutationCoefficient) {
				for(int j = 0; j < problemParameters.dimensions; j++) {
					i.x[j] += rand.nextDouble() * 2*Math.PI - Math.PI;
			}
		}
	}
	
	
	
}
