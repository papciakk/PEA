package pl.edu.agh.pea.Operators.implementation;

import java.util.Random;

import pl.edu.agh.pea.Core.ProblemParameters;
import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.ICrossover;

public class Crossover implements ICrossover {

	private Individual i1;
	private Individual i2;
	private Individual result;
	private ProblemParameters problemParameters;
	
	public void execute() {
		Random rand = new Random();
		
		double[] genotype1 = i1.getGenotype();
		double[] genotype2 = i2.getGenotype();
		int genotypeLenght = genotype1.length;
		int gene1, gene2;
		double newGene;
		
		result = new Individual(problemParameters);
		
		for(int k = 0; k < genotypeLenght; k++) {
			gene1 = rand.nextInt(genotypeLenght-1);
			gene2 = rand.nextInt(genotypeLenght-1);
			newGene = (genotype1[gene1] + genotype2[gene2]) / 2;
			result.setGen(k, newGene); 
		}
	}

	public void setInput(Individual input1, Individual input2, ProblemParameters problemParameters) {
		this.i1 = input1;
		this.i2 = input2;
		this.problemParameters = problemParameters;
	}

	public Individual getResults() {
		return result;
	}

}
