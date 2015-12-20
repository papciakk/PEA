package pl.edu.agh.pea.individuals;

import java.util.Random;

public class Individual {
	private double [] genotype;
	private double fitness;
	protected int dimension;
	
	public Individual (int dimension) {
		this.dimension = dimension;
		this.genotype = new double [dimension];
		randomGenotype();
	}

	public Individual (double [] genotype) {
		if (genotype == null) {
			throw new IllegalArgumentException("Genotype cannot be null");
		}

		if (genotype.length == 0){
			throw new IllegalArgumentException("Genotype cannot be of zero length");
		}

		this.dimension = genotype.length;
		this.genotype = new double[dimension];
		this.setGenotype(genotype);
	}

	public void setFitness(double fitness){
		this.fitness = fitness;
	}

	public double getFitness(){ return this.fitness; }

	public void setGenotype( double [] genotype ) {
		if (genotype == null){
			throw new IllegalArgumentException("Argument cannot be null");
		}

		if (genotype.length != dimension){
			throw new IllegalArgumentException("Wrong length of genotype, should be" + dimension);
		}

		for(int i = 0; i < dimension; i++){
			if (genotype[i] < -5.12 || genotype[i] > 5.12){
				throw new IllegalArgumentException("Gen #" + i + " out of range");
			} else
				this.genotype[i] = genotype[i];
		}
	}

	public void randomGenotype(){
		Random randomNum = new Random();
		double value;

		for(int i = 0; i < dimension; i++){
			value = randomNum.nextDouble()*10.24 - 5.12;
			this.setGen(i, value);
		}
	}

	public double [] getGenotype(){
		return this.genotype;
	}

	public void setGen(int n, double value){
		if (value < -5.12 || value > 5.12){
			throw new IllegalArgumentException("Value of gen out of range");
		} else
			this.genotype[n] = value;
	}

	public double getGen(int n){ return this.genotype[n]; }

	public void printIndividual () {
		System.out.print("Individual with genotype: [");

		for(double g : genotype) {
			System.out.print(String.format("%.3f", g) + " | ");
		}

		System.out.println("]");

		System.out.println("has fitness: " + String.format("%.3f", getFitness()));
	}
}
