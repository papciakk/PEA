package pl.edu.agh.pea.Operators.implementation;

import java.util.List;
import java.util.Random;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator;

public class Crossover implements IOperator {

	private List<Individual> population;
	private Random rand;
	
	public Crossover() {
		rand = new Random();
	}
	
	public void execute() {
		double [] newGenotype;
		double[] genotype1;
		double[] genotype2;
		
		for(Individual i1 : population)
			for(Individual i2 : population)
				if(rand.nextDouble() <= ProblemParameters.crossCoefficient) {
					genotype1 = i1.getGenotype();
					genotype2 = i2.getGenotype();
					
					newGenotype = crossoverIndividuals(genotype1, genotype2);
					population.add(new Individual(newGenotype));
				}
	}

	public void setInputPopulation(List<Individual> population) {
		this.population = population;		
	}
	
	private double[] crossoverIndividuals(double [] genotype1, double [] genotype2) {
		
		int genotypeLenght = genotype1.length;
		
		int gene1, gene2;
		double [] newGenotype = new double [genotypeLenght];
		
		for(int k = 0; k < genotypeLenght; k++) {
			gene1 = rand.nextInt(genotypeLenght-1);
			gene2 = rand.nextInt(genotypeLenght-1);
			
			newGenotype[k] = (genotype1[gene1] + genotype2[gene2]) / 2; 
		}
		return newGenotype;
	}

}
