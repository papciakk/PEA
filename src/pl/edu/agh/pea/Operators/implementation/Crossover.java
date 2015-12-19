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
		population = null;
	}
	
	public void execute() {
		
		if(population == null) {
			System.out.println("Nie ustawiono populacji wejściowej");
			return;
		}
		
		double [] newGenotype;
		double[] genotype1;
		double[] genotype2;
		
		for(int i = 0; i < ProblemParameters.population; i++)
			for(int j = 0; j < ProblemParameters.population; j++) {
				if(rand.nextDouble() <= ProblemParameters.crossCoefficient) {
					genotype1 = population.get(i).getGenotype();
					genotype2 = population.get(j).getGenotype();
					
					newGenotype = crossoverIndividuals(genotype1, genotype2);
					population.add(new Individual(newGenotype));
				}
			}
	}

	public void setInputPopulation(List<Individual> population) {
		if (population != null || population.size() == 0) {
			System.out.println("Populacja nie zostala poprawnie zainicjowana.");
			return;
		}
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
